package gtclassic.items.tools;

import java.util.Arrays;
import java.util.List;

import gtclassic.GTClassic;
import ic2.core.item.base.ItemIC2;
import ic2.core.platform.textures.Ic2Icons;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTItemSonictron extends ItemIC2{
	
	public GTItemSonictron()
	{
		this.maxStackSize = 1;
        this.setCreativeTab(GTClassic.creativeTabGT);
        this.setRegistryName("sonictron_item");
        this.setUnlocalizedName(GTClassic.MODID + ".sonictronItem");
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int meta) 
	{
        return Ic2Icons.getTextures("gtclassic_items")[32];
    }

	@Override
    public List<Integer> getValidVariants() {
        return Arrays.asList(0);
    }

	@Override
	public int getTextureEntry(int var1) {
		return 0;
	}

}
