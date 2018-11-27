package gtclassic.blocks;

import gtclassic.GTClassic;
import gtclassic.util.GTBlocks;
import ic2.core.block.base.BlockMultiID;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.platform.textures.Ic2Icons;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GTBlockEnergy extends BlockMultiID {
    public enum GTBlockEnergyVariants
    {
        //Generators
    	LIGHTNINGROD,
    	FUSIONREACTOR, 
        
    	//Storage
    	LESU,
        IESU,
        AESU; 
    }

    GTBlockEnergyVariants variant;
    public GTBlockEnergy(GTBlockEnergyVariants variant)
    {
        super(Material.IRON);
        this.variant = variant;
        setRegistryName(variant.toString().toLowerCase());
        setUnlocalizedName(GTClassic.MODID + "." + variant.toString().toLowerCase());
        setCreativeTab(GTClassic.creativeTabGT);
        setHardness(4.0F);
        setResistance(20.0F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 2);
    }
    
    @Override
    public List<Integer> getValidMetas() 
	{
        return Arrays.asList(0);
    }

    @Override
    public TileEntityBlock createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityBlock();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite[] getIconSheet(int meta)
    {
    	//Generators
    	if (this == GTBlocks.lightningRod) 
   	 	{
    		return Ic2Icons.getTextures("gtclassic_lightningrod");
   	 	}
   	 
   	 	if (this == GTBlocks.fusionReactor) 
   	 	{
   	 		return Ic2Icons.getTextures("gtclassic_fusionreactor");
   	 	}
   	 
   	 	//Storage
   	 	if (this == GTBlocks.LESU) 
   	 	{
   	 		return Ic2Icons.getTextures("gtclassic_lapotronicenergysu");
   	 	}
   	 
   	 	if (this == GTBlocks.IESU) 
   	 	{
   	 		return Ic2Icons.getTextures("gtclassic_interdimensionalenergysu");
   	 	}
   	 	
   	 	if (this == GTBlocks.AESU) 
	 	{
   	 		return Ic2Icons.getTextures("gtclassic_adjustableenergysu");
	 	}
    	
    	return Ic2Icons.getTextures("gtclassic_builder");
    }
    
    @Override
    public int getMaxSheetSize(int meta)
    {
        return 1;
    }

    @Override
    public List<IBlockState> getValidStateList()
    {
        IBlockState def = getDefaultState();
        List<IBlockState> states = new ArrayList<>();
        for(EnumFacing side : EnumFacing.VALUES)
        {
        	states.add(def.withProperty(getMetadataProperty(), 0).withProperty(allFacings, side).withProperty(active, false));
        	states.add(def.withProperty(getMetadataProperty(), 0).withProperty(allFacings, side).withProperty(active, true));
        }
        return states;
    }

    @Override
    public List<IBlockState> getValidStates()
    {
        return getBlockState().getValidStates();
    }

}