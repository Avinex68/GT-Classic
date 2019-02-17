package gtclassic;

import java.util.ArrayList;
import java.util.List;

import gtclassic.item.GTItemComponent;
import gtclassic.item.GTItemCraftingTablet;
import gtclassic.item.GTItemCreativeScanner;
import gtclassic.item.GTItemDestructoPack;
import gtclassic.item.GTItemDuctTape;
import gtclassic.item.GTItemEchophone;
import gtclassic.item.GTItemElectromagnet;
import gtclassic.item.GTItemSurvivalScanner;
import gtclassic.item.GTItemTeslaStaff;
import gtclassic.material.GTMaterial;
import gtclassic.material.GTMaterialGen;
import gtclassic.tool.GTToolChainsaw;
import gtclassic.tool.GTToolFile;
import gtclassic.tool.GTToolHammer;
import gtclassic.tool.GTToolMiningDrill;
import gtclassic.tool.GTToolRockCutter;
import ic2.core.IC2;
import net.minecraft.item.Item;

public class GTItems {

	static List<Item> toRegister = new ArrayList<Item>();
	public static final GTItemComponent glassTube = createItem(new GTItemComponent("glass_tube", 0, false));
	public static final GTItemComponent bouleSilicon = createItem(new GTItemComponent("silicon_boule", 1, false));
	public static final GTItemComponent boardRefinedIron = createItem(
			new GTItemComponent("refinediron_circuit_board", 2, false));
	public static final GTItemComponent boardAluminium = createItem(
			new GTItemComponent("aluminium_circuit_board", 3, false));
	public static final GTItemComponent boardElectrum = createItem(
			new GTItemComponent("electrum_circuit_board", 4, false));
	public static final GTItemComponent boardPlatinum = createItem(
			new GTItemComponent("platinum_circuit_board", 5, false));
	public static final GTItemComponent circuitParts = createItem(new GTItemComponent("circuit_parts", 6, false));
	public static final GTItemComponent circuitDiamond = createItem(new GTItemComponent("circuit_diamond", 7, false));
	public static final GTItemComponent circuitRuby = createItem(new GTItemComponent("circuit_ruby", 8, false));
	public static final GTItemComponent circuitEmerald = createItem(new GTItemComponent("circuit_emerald", 9, false));
	public static final GTItemComponent circuitSapphire = createItem(new GTItemComponent("circut_sapphire", 10, false));

	public static final GTItemDuctTape braintechAerospaceARDT = createItem(new GTItemDuctTape());
	public static final GTItemEchophone sonictronItem = createItem(new GTItemEchophone());
	public static final GTItemDestructoPack destructoPack = createItem(new GTItemDestructoPack());
	public static final GTItemCraftingTablet craftingTablet = createItem(new GTItemCraftingTablet());

	public static final GTToolFile fileIron = createItem(new GTToolFile(GTMaterial.Iron));
	public static final GTToolFile fileTitanium = createItem(new GTToolFile(GTMaterial.Titanium));
	public static final GTToolFile fileTungstenSteel = createItem(new GTToolFile(GTMaterial.TungstenSteel));

	public static final GTToolHammer hammerIron = createItem(new GTToolHammer(GTMaterial.Iron));
	public static final GTToolHammer hammerTitanium = createItem(new GTToolHammer(GTMaterial.Titanium));
	public static final GTToolHammer hammerTungstenSteel = createItem(new GTToolHammer(GTMaterial.TungstenSteel));

	public static final GTToolMiningDrill advancedDrill = createItem(
			new GTToolMiningDrill(GTMaterial.Steel, 100000, 128, 1));
	public static final GTToolMiningDrill advancedDrill2 = createItem(
			new GTToolMiningDrill(GTMaterial.Diamond, 200000, 256, 2));
	public static final GTToolMiningDrill advancedDrill3 = createItem(
			new GTToolMiningDrill(GTMaterial.Diamond, 400000, 512, 3));

	public static final GTToolChainsaw advancedChainsaw = createItem(
			new GTToolChainsaw(GTMaterial.Steel, 100000, 128, 1));
	public static final GTToolChainsaw advancedChainsaw2 = createItem(
			new GTToolChainsaw(GTMaterial.Titanium, 200000, 256, 2));
	public static final GTToolChainsaw advancedChainsaw3 = createItem(
			new GTToolChainsaw(GTMaterial.TungstenSteel, 400000, 512, 3));

	public static final GTToolRockCutter rockCutter = createItem(
			new GTToolRockCutter(GTMaterial.Diamond, 10000, 100, 1));

	public static final GTItemElectromagnet electroMagnet = createItem(new GTItemElectromagnet());
	public static final GTItemTeslaStaff teslaStaff = createItem(new GTItemTeslaStaff());

	public static final GTItemCreativeScanner debugScanner = createItem(new GTItemCreativeScanner());
	public static final GTItemSurvivalScanner portableScanner = createItem(new GTItemSurvivalScanner());

	public static <T extends Item> T createItem(T item) {
		toRegister.add(item);
		return item;
	}

	public static void registerItems() {
		for (Item item : GTMaterialGen.itemMap.values()) {
			IC2.getInstance().createItem(item);
		}

		for (Item item : toRegister) {
			IC2.getInstance().createItem(item);
		}
	}

}