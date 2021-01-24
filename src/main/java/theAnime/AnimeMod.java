package theAnime;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.mod.stslib.Keyword;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import theAnime.cards.AbstractTodoCard;
import theAnime.relics.AbstractTodoRelic;
import theAnime.util.KeyPotion;
import theAnime.util.SecondDamage;
import theAnime.util.SillyVariable;
import theAnime.util.TextureLoader;

import java.nio.charset.StandardCharsets;

@SuppressWarnings({"ConstantConditions", "unused", "WeakerAccess"})
@SpireInitializer
public class AnimeMod implements
        EditCardsSubscriber,
        EditRelicsSubscriber,
        EditStringsSubscriber,
        EditKeywordsSubscriber,
        EditCharactersSubscriber,
        PostInitializeSubscriber,
        PostUpdateSubscriber {
    public static final String SHOULDER = "locksmithResources/images/char/mainChar/shoulder.png";
    public static final String SHOULDER2 = "locksmithResources/images/char/mainChar/shoulder2.png";
    public static final String CORPSE = "locksmithResources/images/char/mainChar/corpse.png";
    private static final String ATTACK_S_ART = "locksmithResources/images/512/attack.png";
    private static final String SKILL_S_ART = "locksmithResources/images/512/skill.png";
    private static final String POWER_S_ART = "locksmithResources/images/512/power.png";
    private static final String CARD_ENERGY_S = "locksmithResources/images/512/energy.png";
    private static final String TEXT_ENERGY = "locksmithResources/images/512/text_energy.png";
    private static final String ATTACK_L_ART = "locksmithResources/images/1024/attack.png";
    private static final String SKILL_L_ART = "locksmithResources/images/1024/skill.png";
    private static final String POWER_L_ART = "locksmithResources/images/1024/power.png";
    private static final String CARD_ENERGY_L = "locksmithResources/images/1024/energy.png";
    private static final String CHARSELECT_BUTTON = "locksmithResources/images/charSelect/charButton.png";
    private static final String CHARSELECT_PORTRAIT = "locksmithResources/images/charSelect/charBG.png";
    private static String modID;
    private static String artifactID;
    public static final TextureAtlas UIAtlas = new TextureAtlas();
    public static Texture lockOrb;
    public static Texture bigLockOrb;
    public static Color rainbow = new Color(1F, 0, 0, 1F);
    private static final float velocity = 0.25f;

    @SpireEnum
    public static AbstractCard.CardTags KEY;

    public static Color todoColor = new Color(0.75F, 0F, 0.25F, 1); //TODO: Set this to your character's favorite color!

    public AnimeMod() {

        BaseMod.subscribe(this);

        modID = "locksmith"; //TODO: Change this!
        artifactID = "TheLocksmith"; //TODO: Change this, but make sure it matches the ArtifactID in your pom.

        BaseMod.addColor(TheAnime.Enums.LOCKSMITH_COLOR, todoColor, todoColor, todoColor,
                todoColor, todoColor, todoColor, todoColor,
                ATTACK_S_ART, SKILL_S_ART, POWER_S_ART, CARD_ENERGY_S,
                ATTACK_L_ART, SKILL_L_ART, POWER_L_ART,
                CARD_ENERGY_L, TEXT_ENERGY);

    }

    public void receivePostUpdate() {
        if (rainbow.g < 1 && rainbow.r >= 1 && rainbow.b <= 0) {
            rainbow.g += velocity * Gdx.graphics.getDeltaTime();
            if (rainbow.g > 1.0F) {
                rainbow.g = 1.0F;
            }
        } else if (rainbow.g >= 1 && rainbow.r > 0 && rainbow.b <= 0) {
            rainbow.r -= velocity * Gdx.graphics.getDeltaTime();
            if (rainbow.r < 0.0F) {
                rainbow.r = 0.0F;
            }
        } else if (rainbow.g >= 1 && rainbow.r <= 0 && rainbow.b < 1) {
            rainbow.b += velocity * Gdx.graphics.getDeltaTime();
            if (rainbow.b > 1.0F) {
                rainbow.b = 1.0F;
            }
        } else if (rainbow.g > 0 && rainbow.r <= 0 && rainbow.b >= 1) {
            rainbow.g -= velocity * Gdx.graphics.getDeltaTime();
            if (rainbow.g < 0.0F) {
                rainbow.g = 0.0F;
            }
        } else if (rainbow.g <= 0 && rainbow.r < 1 && rainbow.b >= 1) {
            rainbow.r += velocity * Gdx.graphics.getDeltaTime();
            if (rainbow.r > 1.0F) {
                rainbow.r = 1.0F;
            }
        } else if (rainbow.g <= 0 && rainbow.r >= 1 && rainbow.b > 0) {
            rainbow.b -= velocity * Gdx.graphics.getDeltaTime();
            if (rainbow.b < 0.0F) {
                rainbow.b = 0.0F;
            }
        }
    }

    public static String makeCardPath(String resourcePath) {
        return getModID() + "Resources/images/cards/" + resourcePath;
    }

    public static String makeRelicPath(String resourcePath) {
        return getModID() + "Resources/images/relics/" + resourcePath;
    }

    public static String makeRelicOutlinePath(String resourcePath) {
        return getModID() + "Resources/images/relics/outline/" + resourcePath;
    }

    public static String makePowerPath(String resourcePath) {
        return getModID() + "Resources/images/powers/" + resourcePath;
    }

    public static String getModID() {
        return modID;
    }

    public static void initialize() {
        AnimeMod animeMod = new AnimeMod();
    }

    public static String makeID(String idText) {
        return getModID() + ":" + idText;
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new TheAnime("the Todo", TheAnime.Enums.THE_LOCKSMITH),
                CHARSELECT_BUTTON, CHARSELECT_PORTRAIT, TheAnime.Enums.THE_LOCKSMITH);
    }

    @Override
    public void receiveEditRelics() {
        new AutoAdd(artifactID)
                .packageFilter(AbstractTodoRelic.class)
                .any(AbstractTodoRelic.class, (info, relic) -> {
                    if (relic.color == null) {
                        BaseMod.addRelic(relic, RelicType.SHARED);
                    } else {
                        BaseMod.addRelicToCustomPool(relic, relic.color);
                    }
                    if (!info.seen) {
                        UnlockTracker.markRelicAsSeen(relic.relicId);
                    }
                });
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addDynamicVariable(new SillyVariable());
        BaseMod.addDynamicVariable(new SecondDamage());
        new AutoAdd(artifactID)
                .packageFilter(AbstractTodoCard.class)
                .setDefaultSeen(true)
                .cards();
    }


    @Override
    public void receiveEditStrings() {
        BaseMod.loadCustomStringsFile(CardStrings.class, getModID() + "Resources/localization/eng/Cardstrings.json");

        BaseMod.loadCustomStringsFile(RelicStrings.class, getModID() + "Resources/localization/eng/Relicstrings.json");

        BaseMod.loadCustomStringsFile(CharacterStrings.class, getModID() + "Resources/localization/eng/Charstrings.json");
    }

    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String json = Gdx.files.internal(getModID() + "Resources/localization/eng/Keywordstrings.json").readString(String.valueOf(StandardCharsets.UTF_8));
        com.evacipated.cardcrawl.mod.stslib.Keyword[] keywords = gson.fromJson(json, com.evacipated.cardcrawl.mod.stslib.Keyword[].class);

        if (keywords != null) {
            for (Keyword keyword : keywords) {
                BaseMod.addKeyword(modID, keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }

    @Override
    public void receivePostInitialize() {
        lockOrb = TextureLoader.getTexture("locksmithResources/images/ui/lock_orb_2.png");
        bigLockOrb = TextureLoader.getTexture("locksmithResources/images/ui/lock.png");
        UIAtlas.addRegion("lockOrb", lockOrb, 0, 0, lockOrb.getWidth(), lockOrb.getHeight());
        UIAtlas.addRegion("bigLock", bigLockOrb, 0, 0, lockOrb.getWidth(), lockOrb.getHeight());

        BaseMod.addPotion(KeyPotion.class, Color.YELLOW, Color.BLACK, Color.PINK, KeyPotion.POTION_ID, TheAnime.Enums.THE_LOCKSMITH);
    }
}
