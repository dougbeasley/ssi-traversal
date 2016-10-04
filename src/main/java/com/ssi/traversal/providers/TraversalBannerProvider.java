package com.ssi.traversal.providers;

import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.BannerProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class TraversalBannerProvider implements BannerProvider {


    private static final String VERSION = "1.0.0";
    private static final String BANNER = "___________                                            .__   \n" +
            "\\__    _______________ ___  __ ___________ __________  |  |  \n" +
            "  |    |  \\_  __ \\__  \\\\  \\/ _/ __ \\_  __ /  ___\\__  \\ |  |  \n" +
            "  |    |   |  | \\// __ \\\\   /\\  ___/|  | \\\\___ \\ / __ \\|  |__\n" +
            "  |____|   |__|  (____  /\\_/  \\___  |__| /____  (____  |____/\n" +
            "                      \\/          \\/          \\/     \\/      \n";
    @Override
    public String getBanner() {
        return BANNER;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public String getWelcomeMessage() {
        return "Path Traversal";
    }

    @Override
    public String getProviderName() {
        return "traversal";
    }
}
