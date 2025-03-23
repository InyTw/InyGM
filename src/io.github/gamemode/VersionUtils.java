package io.github.gamemode;

public class VersionUtils {

    /**
     * 检测是否为旧版 Minecraft (1.8 - 1.10)
     * @param version 服务器版本字符串
     * @return 如果是旧版，则返回 true
     */
    public static boolean isLegacyVersion(String version) {
        return version.startsWith("v1_8") || version.startsWith("v1_9") || version.startsWith("v1_10");
    }

    /**
     * 检测是否为现代 Minecraft 版本 (1.20 - 1.21.4)
     * @param version 服务器版本字符串
     * @return 如果是现代版本，则返回 true
     */
    public static boolean isModernVersion(String version) {
        return version.startsWith("v1_20") || version.startsWith("v1_21");
    }

    /**
     * 根据服务器版本执行具体逻辑
     * @param version 服务器版本字符串
     */
    public static void handleVersionLogic(String version) {
        if (isLegacyVersion(version)) {
            System.out.println("正在处理旧版逻辑...");
            // 这里可以实现旧版行为
        } else if (isModernVersion(version)) {
            System.out.println("正在处理现代版逻辑...");
            // 这里可以实现现代行为
        } else {
            System.out.println("版本不受支持：" + version);
        }
    }
}
