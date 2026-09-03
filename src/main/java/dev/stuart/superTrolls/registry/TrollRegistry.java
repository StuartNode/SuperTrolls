package dev.stuart.superTrolls.registry;

import dev.stuart.superTrolls.ability.InvSwap;
import dev.stuart.superTrolls.ability.Launch;
import dev.stuart.superTrolls.ability.Smite;
import dev.stuart.superTrolls.action.TrollAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TrollRegistry {
    private static final List<TrollAction> TROLLS = new ArrayList<>();

    static {
        register(new Launch());
        register(new Smite());
        register(new InvSwap());
    }

    public static void register(TrollAction troll) {
        TROLLS.add(troll);
    }

    public static List<TrollAction> getTrolls() {
        return Collections.unmodifiableList(TROLLS);
    }

    private TrollRegistry() {}
}
