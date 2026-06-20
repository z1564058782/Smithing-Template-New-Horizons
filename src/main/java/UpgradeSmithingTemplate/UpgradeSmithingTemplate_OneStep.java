package UpgradeSmithingTemplate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UpgradeSmithingTemplate_OneStep  extends Item {

    /**
     * 物品的纹理图标
     * 用于在游戏内渲染该物品的材质
     */
    @SideOnly(Side.CLIENT)
    private IIcon icon;

    /**
     * 物品的内部名称
     * 用于注册和识别该物品
     */
    private static final String ITEM_NAME = "BaseUpgradeSmithingTemplate";

    /**
     * 物品的显示名称
     * 用于在游戏界面中显示
     */
    private static final String DISPLAY_NAME = "基础升级锻造模板";

    /**
     * 构造函数 - 初始化基础升级锻造模板物品
     * 设置物品的基本属性，包括最大堆叠数量、创造模式标签等
     */
    public UpgradeSmithingTemplate_OneStep() {
        super();
        // 设置最大堆叠数量为64，允许玩家堆叠该物品
        this.setMaxStackSize(64);
        // 设置物品在创造模式标签页中的分类，此处使用搜索标签页便于查找
        this.setCreativeTab(CreativeTabs.tabMisc);
        // 设置物品的未本地化名称，用于后续本地化
        this.setUnlocalizedName(ITEM_NAME);
        // 设置物品的纹理名称，指向纹理文件路径
        // 注意：实际纹理注册在registerIcons方法中完成
        this.setTextureName("baseupgradesmithingtemplate");
    }

    /**
     * 注册物品的纹理图标
     * 该方法在客户端渲染时被调用，用于加载和注册物品的材质
     * 使用@SideOnly注解确保仅在客户端执行
     *
     * @param iconRegister 图标注册器，用于注册纹理
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        // 从指定路径加载纹理：src/main/resources/BaseUpgradeSmithingTemplate.png
        // 在Minecraft中，纹理路径使用资源域(domain)和路径(path)的组合
        // 此处使用默认的minecraft域，实际使用时可能需要自定义域
        // 纹理文件实际位于 assets/minecraft/textures/items/ 或自定义路径
        // 由于纹理文件位于 src/main/resources/BaseUpgradeSmithingTemplate.png，
        // 在Forge中通常需要放在 assets/modid/textures/items/ 目录下
        // 这里使用完整路径进行注册
        // this.icon = iconRegister.registerIcon("baseupgradesmithingtemplate:BaseUpgradeSmithingTemplate");
        // 备选注册方式：如果使用默认域，可直接使用纹理文件名
        this.icon = iconRegister.registerIcon("baseupgradesmithingtemplate");
    }

    /**
     * 获取物品的纹理图标
     * 该方法在客户端渲染时被调用，返回当前物品的图标
     *
     * @param itemStack 物品栈，可以为null
     * @param pass 渲染通道
     * @return 物品的纹理图标
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack itemStack, int pass) {
        // 返回注册的纹理图标
        return this.icon;
    }

    /**
     * 获取物品的纹理图标（重载方法）
     * 用于获取物品在物品栏中显示的图标
     *
     * @param itemStack 物品栈
     * @return 物品的纹理图标
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack itemStack) {
        // 返回注册的纹理图标
        return this.icon;
    }

    /**
     * 获取物品的显示名称
     * 该方法在物品显示时被调用，返回本地化的物品名称
     *
     * @param itemStack 物品栈
     * @return 格式化后的显示名称
     */
    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        // 返回设置的显示名称
        // 实际使用中建议使用本地化文件进行翻译
        return DISPLAY_NAME;
    }

    /**
     * 注册该物品到游戏注册表
     * 此方法需要在主Mod类的加载阶段调用
     *
     * @return 注册后的物品实例
     */
    public static UpgradeSmithingTemplate_OneStep registerItem() {
        // 创建物品实例
        UpgradeSmithingTemplate_OneStep item = new UpgradeSmithingTemplate_OneStep();
        // 使用GameRegistry注册物品
        // 参数：物品实例，物品注册名称
        GameRegistry.registerItem(item, ITEM_NAME);
        // 返回注册后的物品实例
        return item;
    }

    /**
     * 检查两个物品栈是否相等（用于比较）
     * 重写该方法以正确比较锻造模板物品
     *
     * @param stack1 第一个物品栈
     * @param stack2 第二个物品栈
     * @return 如果物品相同返回true，否则返回false
     */
    public static boolean areItemsEqual(ItemStack stack1, ItemStack stack2) {
        // 检查两个物品栈是否都非空
        if (stack1 == null || stack2 == null) {
            return false;
        }
        // 检查两个物品栈中的物品是否为同一个类
        if (stack1.getItem() instanceof UpgradeSmithingTemplate_OneStep &&
            stack2.getItem() instanceof UpgradeSmithingTemplate_OneStep) {
            // 检查物品元数据是否相同（如果有的话）
            return stack1.getItemDamage() == stack2.getItemDamage();
        }
        return false;
    }

    /**
     * 获取物品的未本地化名称
     * 用于本地化系统
     *
     * @param itemStack 物品栈
     * @return 未本地化的物品名称
     */
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        // 返回设置的未本地化名称
        return "item." + ITEM_NAME;
    }

    /**
     * 复制物品栈
     * 创建当前物品的副本
     *
     * @param amount 复制数量
     * @return 新的物品栈副本
     */
    public ItemStack copyItemStack(int amount) {
        // 创建一个新的物品栈，数量为指定数量
        return new ItemStack(this, amount);
    }

    /**
     * 创建默认的物品栈
     * 返回一个数量为1的物品栈
     *
     * @return 默认物品栈
     */
    public ItemStack getDefaultStack() {
        // 返回一个数量为1的物品栈
        return new ItemStack(this, 1);
    }
}
