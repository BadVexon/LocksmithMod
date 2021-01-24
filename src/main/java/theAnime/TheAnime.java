package theAnime;

import basemod.abstracts.CustomEnergyOrb;
import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.cutscenes.CutscenePanel;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import theAnime.cards.Defend;
import theAnime.cards.KeyMove;
import theAnime.cards.LockCrash;
import theAnime.cards.Strike;
import theAnime.relics.FreeKey;

import java.util.ArrayList;
import java.util.List;

import static theAnime.AnimeMod.*;
import static theAnime.TheAnime.Enums.LOCKSMITH_COLOR;

public class TheAnime extends CustomPlayer {
    private static final String[] orbTextures = {
            "locksmithResources/images/char/mainChar/orb/layer1.png",
            "locksmithResources/images/char/mainChar/orb/layer2.png",
            "locksmithResources/images/char/mainChar/orb/layer3.png",
            "locksmithResources/images/char/mainChar/orb/layer4.png",
            "locksmithResources/images/char/mainChar/orb/layer5.png",
            "locksmithResources/images/char/mainChar/orb/layer6.png",
            "locksmithResources/images/char/mainChar/orb/layer1d.png",
            "locksmithResources/images/char/mainChar/orb/layer2d.png",
            "locksmithResources/images/char/mainChar/orb/layer3d.png",
            "locksmithResources/images/char/mainChar/orb/layer4d.png",
            "locksmithResources/images/char/mainChar/orb/layer5d.png",};
    private static final String ID = makeID("theAnime");
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
    private static final String[] NAMES = characterStrings.NAMES;
    private static final String[] TEXT = characterStrings.TEXT;


    public TheAnime(String name, PlayerClass setClass) {
        super(name, setClass, new CustomEnergyOrb(orbTextures, "locksmithResources/images/char/mainChar/orb/vfx.png", null), new SpriterAnimation(
                "locksmithResources/images/char/mainChar/static.scml"));
        initializeClass(null,
                SHOULDER,
                SHOULDER2,
                CORPSE,
                getLoadout(), 20.0F, -10.0F, 166.0F, 327.0F, new EnergyManager(3));


        dialogX = (drawX + 0.0F * Settings.scale);
        dialogY = (drawY + 240.0F * Settings.scale);
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(NAMES[0], TEXT[0],
                79, 79, 0, 99, 5, this, getStartingRelics(),
                getStartingDeck(), false);
        //TODO: Change starting HP and Gold. Or don't
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            retVal.add(Strike.ID);
        }
        for (int i = 0; i < 4; i++) {
            retVal.add(Defend.ID);
        }
        retVal.add(KeyMove.ID);
        retVal.add(LockCrash.ID);
        return retVal;
    }

    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(FreeKey.ID);
        //TODO: Change this too.
        return retVal;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("UNLOCK_PING", MathUtils.random(-0.2F, 0.2F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT,
                false);
        //TODO: Change this to a sound befitting your character.
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "UNLOCK_PING"; //TODO: Change this to a sound befitting your character.
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 8;
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return LOCKSMITH_COLOR;
    }

    @Override
    public Color getCardTrailColor() {
        return todoColor.cpy();
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public String getLocalizedCharacterName() {
        return NAMES[0];
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new KeyMove();
        //TODO: Change this to your character's special starting card.
    }

    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
        return NAMES[1];
    }

    @Override
    public AbstractPlayer newInstance() {
        return new TheAnime(name, chosenClass);
    }

    @Override
    public Color getCardRenderColor() {
        return todoColor.cpy();
    }

    @Override
    public Color getSlashAttackColor() {
        return todoColor.cpy();
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{
                AbstractGameAction.AttackEffect.FIRE,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.FIRE};
    }

    @Override
    public List<CutscenePanel> getCutscenePanels() {
        return super.getCutscenePanels();
        //TODO: Override this if you want an alternate heart win comic
    }

    @Override
    public String getSpireHeartText() {
        return TEXT[1];
    }

    @Override
    public String getVampireText() {
        return TEXT[2];
    }

    public static class Enums {
        @SpireEnum
        public static AbstractPlayer.PlayerClass THE_LOCKSMITH;
        @SpireEnum(name = "LOCKSMITH_COLOR")
        public static AbstractCard.CardColor LOCKSMITH_COLOR;
        @SpireEnum(name = "LOCKSMITH_COLOR")
        @SuppressWarnings("unused")
        public static CardLibrary.LibraryType LIBRARY_COLOR;
    }
}
