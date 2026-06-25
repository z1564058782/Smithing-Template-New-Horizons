package loader;

import Machine.Upgrader;
import gregtech.api.GregTechAPI;
import gregtech.api.casing.Casings;
import gregtech.api.enums.Textures;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;

public class MachineLoader {
    public static ItemStack UpgraderMain;

    public static void loaderMachines() {
        UpgraderMain = new Upgrader(25568, "Upgrader", "Upgrader").getStackForm(1);
    }
}
