package UpgradeSmithingTemplate;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class UpgradeSmithingTemplate extends Item {
    public static final String[] unlocalizedName = new String[] {
        "UpgradeSmithingTemplate_ULV-LV",
        "UpgradeSmithingTemplate_LV-MV",
        "UpgradeSmithingTemplate_MV-HV",
        "UpgradeSmithingTemplate_HV-EV",
        "UpgradeSmithingTemplate_EV-IV",
        "UpgradeSmithingTemplate_IV-LuV",
        "UpgradeSmithingTemplate_LuV-ZPM",
        "UpgradeSmithingTemplate_ZPM-UV",
        "UpgradeSmithingTemplate_UV-UHV",
        "UpgradeSmithingTemplate_UHV-UEV",
        "UpgradeSmithingTemplate_UEV-UIV",
        "UpgradeSmithingTemplate_UIV-UMV",
        "UpgradeSmithingTemplate_UMV-UXV",
        "UpgradeSmithingTemplate_UXV-MAX",
        "UpgradeSmithingTemplate_Tier1",
        "UpgradeSmithingTemplate_Tier2",
        "UpgradeSmithingTemplate_Tier3",
        "UpgradeSmithingTemplate_Tier4",
        "UpgradeSmithingTemplate_Tier5",
        "UpgradeSmithingTemplate_Tier6",
        "UpgradeSmithingTemplate_Tier7",
        "UpgradeSmithingTemplate_Tier8",
        "UpgradeSmithingTemplate_Tier9",
        "UpgradeSmithingTemplate_Tier10",
        "UpgradeSmithingTemplate_Tier11",
        "UpgradeSmithingTemplate_Tier12",
        "UpgradeSmithingTemplate_Tier13",
        "UpgradeSmithingTemplate_Tier14",
        "UpgradeSmithingTemplate_Tier15"
    };

    public static final String[] textureName = new String[] {
        "UpgradeSmithingTemplate_ULV-LV",
        "UpgradeSmithingTemplate_LV-MV",
        "UpgradeSmithingTemplate_MV-HV",
        "UpgradeSmithingTemplate_HV-EV",
        "UpgradeSmithingTemplate_EV-IV",
        "UpgradeSmithingTemplate_IV-LuV",
        "UpgradeSmithingTemplate_LuV-ZPM",
        "UpgradeSmithingTemplate_ZPM-UV",
        "UpgradeSmithingTemplate_UV-UHV",
        "UpgradeSmithingTemplate_UHV-UEV",
        "UpgradeSmithingTemplate_UEV-UIV",
        "UpgradeSmithingTemplate_UIV-UMV",
        "UpgradeSmithingTemplate_UMV-UXV",
        "UpgradeSmithingTemplate_UXV-MAX",
        "UpgradeSmithingTemplate_Tier1",
        "UpgradeSmithingTemplate_Tier2",
        "UpgradeSmithingTemplate_Tier3",
        "UpgradeSmithingTemplate_Tier4",
        "UpgradeSmithingTemplate_Tier5",
        "UpgradeSmithingTemplate_Tier6",
        "UpgradeSmithingTemplate_Tier7",
        "UpgradeSmithingTemplate_Tier8",
        "UpgradeSmithingTemplate_Tier9",
        "UpgradeSmithingTemplate_Tier10",
        "UpgradeSmithingTemplate_Tier11",
        "UpgradeSmithingTemplate_Tier12",
        "UpgradeSmithingTemplate_Tier13",
        "UpgradeSmithingTemplate_Tier14",
        "UpgradeSmithingTemplate_Tier15"
    };

    private IIcon[] textureImage;

    public int TotalQuantity = unlocalizedName.length;

    // 构造函数接受名称参数
    public UpgradeSmithingTemplate(){
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int aID) {
        int j = MathHelper.clamp_int(aID, 0, TotalQuantity);
        return this.textureImage[j];
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int i = MathHelper.clamp_int(stack.getItemDamage(), 0, TotalQuantity);
        return super.getUnlocalizedName() + "." + unlocalizedName[i];
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item UpgradeSmithingTemplate, CreativeTabs p_150895_2_, List<ItemStack> List_UpgradeSmithingTemplate)
    {
        for (int i = 0; i < TotalQuantity; ++i)
        {
            List_UpgradeSmithingTemplate.add(new ItemStack(UpgradeSmithingTemplate, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.textureImage = new IIcon[textureName.length];

        for (int i = 0; i < textureName.length; ++i)
        {
            this.textureImage[i] = register.registerIcon("smithingtemplatenewhorizons:" + textureName[i]);
        }
    }
}
