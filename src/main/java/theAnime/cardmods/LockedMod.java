package theAnime.cardmods;

import basemod.abstracts.AbstractCardModifier;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import theAnime.AnimeMod;
import theAnime.cards.Key;

public class LockedMod extends AbstractCardModifier {

    private boolean inherent;
    public int amount;
    public boolean unlocked = false;

    public LockedMod(int ab, boolean br) {
        inherent = br;
        amount = ab;
        this.priority = -999;
    }

    @Override
    public void onInitialApplication(AbstractCard card) {
        card.cardsToPreview = new Key();
    }

    public static final String ID = "locksmith:locked";

    @Override
    public String identifier(AbstractCard card) {
        return ID;
    }

    @Override
    public boolean isInherent(AbstractCard card) {
        return inherent;
    }

    @Override
    public AbstractCardModifier makeCopy() {
        return new LockedMod(amount, inherent);
    }
}
