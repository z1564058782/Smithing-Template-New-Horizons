package loader;

import UpgradeSmithingTemplate.UpgradeSmithingTemplate;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.GregTechAPI;
import gregtech.api.casing.Casings;
import gregtech.api.enums.Textures;
import gregtech.api.util.GTUtility;
import net.minecraft.item.Item;

public class ItemLoader {

    public static Item upgradeSmithingTemplate;

    public ItemLoader(FMLPreInitializationEvent event) {
        upgradeSmithingTemplate = (new UpgradeSmithingTemplate()).setUnlocalizedName("upgrade_smithing_template");
        GameRegistry.registerItem(upgradeSmithingTemplate, "upgrade_smithing_template");

    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item, name);
    }
}
