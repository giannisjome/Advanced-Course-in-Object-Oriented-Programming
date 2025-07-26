# Question 4

This document provides a **design specification** for a simplified text-based RPG battle engine in Java.  
The design focuses on **object-oriented principles** and **routine abstraction** to ensure **reusability, scalability, and flexibility**.  
The system is built for command-line interaction but can easily evolve into a **web-based application**.

---

## **Goals**
- **Reusable & scalable** combat core with clear services/utilities.
- **OO & interface-driven** design (easy integration of new combatants, abilities, and battle modes).
- **Deterministic and testable** battle loop.
- **Extensible** to teams, new terrains, time-of-day effects, new character classes, and more.

---

## **High-Level Architecture**

rpg/
├─ domain/
│ ├─ combatant/
│ │ ├─ Combatant (abstract)
│ │ ├─ Warrior, Mage, Archer ...
│ │ └─ Stats
│ ├─ ability/
│ │ ├─ Ability (interface)
│ │ ├─ PassiveAbility, ActiveAbility
│ │ └─ StatusEffect
│ ├─ env/
│ │ ├─ Environment
│ │ ├─ Terrain (enum)
│ │ └─ TimeOfDay (enum)
│ ├─ action/
│ │ ├─ Action (interface)
│ │ ├─ AttackAction, AbilityAction, DefendAction, SkipAction
│ │ └─ TargetingStrategy (interface)
│ └─ result/
│ ├─ BattleResult
│ ├─ RoundSummary
│ └─ CombatLogEntry
├─ engine/
│ ├─ BattleEngine
│ ├─ TurnOrderService
│ ├─ DamageCalculator
│ ├─ ModifierPipeline
│ ├─ AbilityResolver
│ ├─ StatusEffectService
│ └─ VictoryService
├─ modes/
│ ├─ BattleMode (interface)
│ ├─ DuelBattleMode
│ └─ TeamBattleMode
├─ io/
│ ├─ BattleCLI
│ └─ Serializer (optional, for saving configs)
└─ util/
└─ RandomProvider, MathUtil, etc.

```java
public final class Stats {
    private final int maxHealth;
    private final int attack;
    private final int defense;
    private final int speed;
    // Optional: mana, critChance, accuracy, dodge, etc.
}
```
# Combatant

```java
public abstract class Combatant {
    private final String id;
    private final String name;
    private final Stats baseStats;
    private int currentHealth;

    private final List<Ability> abilities;
    private final List<StatusEffect> activeEffects;

    public boolean isAlive();
    public void takeDamage(int rawAmount);
    public void heal(int amount);
    public Stats getEffectiveStats(); // base + effects
    public List<Ability> getAbilities();
}
```
# Abilities & Effects

## Ability
```java
public interface Ability {
    String name();
    boolean isPassive();
    void apply(AbilityContext ctx);
    boolean canUse(AbilityContext ctx);
}
```
# AbilityContext

```java
public record AbilityContext(
    Combatant user,
    List<Combatant> allies,
    List<Combatant> enemies,
    Environment environment,
    BattleLog log
) {}
```
# StatusEffect

```java
public interface StatusEffect {
    String name();
    void onApply(Combatant target);
    void onExpire(Combatant target);
    void onRoundStart(Combatant target, BattleContext ctx);
    void onBeforeDamage(DamageContext ctx);
    void onAfterDamage(DamageContext ctx);
    int remainingRounds();
    void tick();
}

```
# Environment

```java
public enum Terrain { PLAIN, WOODS, DESERT, MOUNTAIN }
public enum TimeOfDay { DAY, NIGHT }

public record Environment(Terrain terrain, TimeOfDay timeOfDay) {}
```
# Actions

```java
public interface Action {
    String name();
    void execute(ActionContext ctx);
}

public final class AttackAction implements Action { ... }
public final class AbilityAction implements Action { ... }
public final class DefendAction implements Action { ... }
public final class SkipAction implements Action { ... }

```
# Engine Services

## BattleEngine
Coordinates the entire battle:
```java
public final class BattleEngine {
    private final BattleMode mode;
    private final TurnOrderService turnOrderService;
    private final DamageCalculator damageCalculator;
    private final AbilityResolver abilityResolver;
    private final StatusEffectService statusService;
    private final VictoryService victoryService;
    private final ModifierPipeline modifierPipeline;

    public BattleResult run(BattleConfig config);
}
```
# BattleMode

```java
public interface BattleMode {
    boolean isBattleOver(List<Combatant> combatants);
    List<List<Combatant>> getTeams(List<Combatant> combatants);
    Optional<Combatant> getWinner(List<Combatant> combatants);
}
```
# TurnOrderService

Determines the order of turns (e.g., based on speed):

```java
public final class TurnOrderService {
    public List<Combatant> order(List<Combatant> aliveCombatants);
}

```
# DamageCalculator

Handles damage calculations:

```java
public final class DamageCalculator {
    public int computeDamage(Combatant attacker, Combatant defender, Environment env, DamageContext ctx);
}
```









