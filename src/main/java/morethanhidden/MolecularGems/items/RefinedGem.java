package morethanhidden.MolecularGems.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import morethanhidden.MolecularGems.MainRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RefinedGem extends Item {
	public static final String[] itemNames = new String[] {"refinedClinohumite", "refinedSugilite", "refinedJadite"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] item_icon;
	
	public RefinedGem() {
		 super();
		setHasSubtypes(true);
		maxStackSize = 64;
        setCreativeTab(MainRegistry.tabmoleculargems);
}

	int itemcount = 3;

	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	         int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, itemcount-1);
	         return super.getUnlocalizedName() + "." + itemNames[i];
	}
	
	@Override
		public void getSubItems(Item par1, CreativeTabs creativeTabs, List list)
		{
		         for (int j = 0; j < itemcount; ++j)
		         {
		                 list.add(new ItemStack(this, 1, j));
		         }
		}
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
	         this.item_icon = new IIcon[itemNames.length];

	         for (int i = 0; i < itemNames.length; ++i)
	         {
	                 this.item_icon[i] = par1IconRegister.registerIcon("moleculargems:" + itemNames[i]);
	         }
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
	{
	         int j = MathHelper.clamp_int(par1, 0, itemcount-1);
	         return this.item_icon[j];
	}
}

