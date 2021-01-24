package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.cards.AbstractTodoCard;
import theAnime.monsters.AbstractDummy;
import theAnime.util.TextureLoader;

public class ReflectHexPower extends AbstractPower implements CloneablePowerInterface, OnLoseHpMonsterPower {
    public static final String POWER_ID = AnimeMod.makeID("ReflectHexPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Voodoo84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Voodoo32.png");

    public ReflectHexPower(AbstractCreature owner) {
        name = "Mirror Pain";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = -1;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onLoseHpMonster(int damageAmount) {
        if (damageAmount > 0) {
            flash();
            for (AbstractMonster q : AbstractTodoCard.monsterList()) {
                if (!(q instanceof AbstractDummy)) {
                    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(q, owner, new HexxPower(q, damageAmount), damageAmount));
                }
            }
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new ReflectHexPower(owner);
    }

    @Override
    public void updateDescription() {
        description = "Whenever " + owner.name + " loses HP, all non-Dummy enemies gain that much #yHexx.";
    }
}