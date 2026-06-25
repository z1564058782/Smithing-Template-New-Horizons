package loader;

import net.minecraft.item.Item;

import UpgradeSmithingTemplate.UpgradeSmithingTemplate;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemLoader {

    public static Item upgradeSmithingTemplate;

    public ItemLoader(FMLPreInitializationEvent event) {
        upgradeSmithingTemplate = (new UpgradeSmithingTemplate()).setUnlocalizedName("upgrade_smithing_template");
        GameRegistry.registerItem(upgradeSmithingTemplate, "upgrade_smithing_template");

    }

    private static void register(Item item, String name) {
        GameRegistry.registerItem(item, name);
    }
}
