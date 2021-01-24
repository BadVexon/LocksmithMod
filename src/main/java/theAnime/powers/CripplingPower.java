package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import theAnime.AnimeMod;
import theAnime.cards.AbstractTodoCard;
import theAnime.util.TextureLoader;

public class CripplingPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("CripplingPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Crippling84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Crippling32.png");

    public CripplingPower(AbstractCreature owner, int amount) {
        name = "Cripppling Stare";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onDeath() {
        flash();
        for (AbstractMonster q : AbstractTodoCard.monsterList()) {
            addToBot(new ApplyPowerAction(q, owner, new WeakPower(q, amount, false), amount));
            addToBot(new ApplyPowerAction(q, owner, new VulnerablePower(q, amount, false), amount));
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new CripplingPower(owner, amount);
    }

    @Override
    public void updateDescription() {
        description = "When " + owner.name + " dies, it applies #b" + amount + " #yWeak and #yVulnerable to ALL enemies.";
    }
}