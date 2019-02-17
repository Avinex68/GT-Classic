package gtclassic.util.recipe;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import ic2.api.classic.recipe.machine.MachineOutput;
import ic2.api.recipe.IRecipeInput;
import ic2.core.block.machine.recipes.managers.RecipeManager;
import ic2.core.util.helpers.ItemWithMeta;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

public class GTMultiInputRecipeList {
	public static final MultiRecipe INVALID_RECIPE = new MultiRecipe(new ArrayList<IRecipeInput>(),
			new MachineOutput(null, new ArrayList<ItemStack>()), "Invalid");

	protected List<MultiRecipe> recipes = new ArrayList<MultiRecipe>();
	protected Map<String, MultiRecipe> recipeMap = new LinkedHashMap<String, MultiRecipe>();
	protected Map<ItemWithMeta, List<IRecipeInput>> validInputs = new LinkedHashMap<ItemWithMeta, List<IRecipeInput>>();
	String category;

	public GTMultiInputRecipeList(String category) {
		this.category = category;
	}

	public void addRecipe(List<IRecipeInput> inputs, MachineOutput output, String id) {
		if (recipeMap.containsKey(id) || !RecipeManager.register(category, id)) {
			return;
		}
		for (int i = 0; i < inputs.size(); i++) {
			if (inputs.get(i) != null && isListInvalid(inputs.get(i).getInputs())) {
				FMLLog.getLogger().info("Recipe[" + id + "] has a invalid input");
				return;
			}
		}
		if (isListInvalid(output.getAllOutputs())) {
			FMLLog.getLogger().info("Recipe[" + id + "] has a invalid output");
			return;
		}
		MultiRecipe recipe = new MultiRecipe(inputs, output, id);
		recipes.add(recipe);
		recipeMap.put(id, recipe);
		for (int i = 0; i < inputs.size(); i++) {
			if (inputs.get(i) != null) {
				for (ItemStack stack : inputs.get(i).getInputs()) {
					ItemWithMeta meta = new ItemWithMeta(stack);
					List<IRecipeInput> list = validInputs.get(meta);
					if (list == null) {
						list = new ArrayList<IRecipeInput>();
						validInputs.put(meta, list);
					}
					list.add(inputs.get(i));
				}
			}
		}
	}

	public boolean isValidRecipeInput(ItemStack stack) {
		List<IRecipeInput> inputs = validInputs.get(new ItemWithMeta(stack));
		if (inputs == null) {
			return false;
		}
		for (IRecipeInput input : inputs) {
			if (input.matches(stack)) {
				return true;
			}
		}
		return false;
	}

	public MultiRecipe getRecipe(Predicate<MultiRecipe> checker) {
		for (MultiRecipe recipe : recipes) {
			if (checker.test(recipe)) {
				return recipe;
			}
		}
		return INVALID_RECIPE;
	}

	public MultiRecipe getFromID(String id) {
		return recipeMap.get(id);
	}

	private boolean isListInvalid(List<ItemStack> list) {
		if (list.isEmpty()) {
			return false;
		}
		for (ItemStack stack : list) {
			if (stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public static class MultiRecipe {
		List<IRecipeInput> inputs;
		MachineOutput outputs;
		String id;

		public MultiRecipe(List<IRecipeInput> inputs, MachineOutput outputs, String id) {
			this.inputs = inputs;
			this.outputs = outputs;
			this.id = id;
		}

		public String getRecipeID() {
			return id;
		}

		public int getInputSize() {
			return inputs.size();
		}

		public IRecipeInput getInput(int slot) {
			if (inputs.size() >= slot) {
				return null;
			}
			return inputs.get(slot);
		}

		public boolean matches(int slot, ItemStack stack) {
			if (inputs.size() >= slot) {
				return stack.isEmpty();
			}
			IRecipeInput input = inputs.get(slot);
			return input == null ? stack.isEmpty() : (input.matches(stack) && input.getAmount() <= stack.getCount());
		}

		public List<IRecipeInput> getInputs() {
			return inputs;
		}

		public MachineOutput getOutputs() {
			return outputs;
		}

	}
}