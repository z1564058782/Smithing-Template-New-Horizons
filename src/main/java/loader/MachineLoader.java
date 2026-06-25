package loader;

import net.minecraft.item.ItemStack;

import Machine.Upgrader;

public class MachineLoader {

    public static ItemStack UpgraderMain;

    public static void loaderMachines() {
        UpgraderMain = new Upgrader(25568, "Upgrader", "Upgrader").getStackForm(1);
    }
}
