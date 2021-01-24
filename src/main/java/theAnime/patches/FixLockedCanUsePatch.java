package theAnime.patches;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.evacipated.cardcrawl.modthespire.lib.LineFinder;
import com.evacipated.cardcrawl.modthespire.lib.Matcher;
import com.evacipated.cardcrawl.modthespire.lib.SpireInsertLocator;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import javassist.CtBehavior;
import theAnime.AnimeMod;
import theAnime.cardmods.LockedMod;

@SpirePatch(
        clz = AbstractCard.class,
        method = "hasEnoughEnergy"
)
public class FixLockedCanUsePatch {
    public static boolean ACTIVE = true;

    public static boolean Postfix(boolean __result, AbstractCard __instance) {
        if (!__instance.freeToPlayOnce && CardModifierManager.hasModifier(__instance, LockedMod.ID) && ACTIVE) {
            __instance.cantUseMessage = "I don't have enough Keys!";
            for (AbstractCardModifier q : CardModifierManager.getModifiers(__instance, LockedMod.ID)) {
                if (q instanceof LockedMod)
                    if (!((LockedMod) q).unlocked)
                        return (AbstractDungeon.player.hand.group.stream().filter(c -> c.hasTag(AnimeMod.KEY)).count() >= ((LockedMod) q).amount) && __result;
            }
        }
        return __result;
    }
}