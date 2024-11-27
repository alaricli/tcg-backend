export interface NavLink {
  href: string;
  label: string;
}

export type Card = {
  id: number;
  name: string | null;
  hp: number | null;
  retreatCost: number | null;
  artist: string | null;
  picUrl: string | null;
  ability: boolean | null;
  price: number | null;
  cardType: CardType | null;
  pokemonCardTypes: PokemonCardType[] | null;
  trainerCardTypes: TrainerCardType[] | null;
  energyCardTypes: EnergyCardType[] | null;
  energyType: EnergyType | null;
  attackEnergyType: EnergyType | null;
  weakness: EnergyType | null;
  resistance: EnergyType | null;
  rarity: Rarity | null;
  format: Format | null;
  expansionName: string | null;
  cardNumber: number | null;
};

export enum CardType {
  POKEMON = "POKEMON",
  TRAINER = "TRAINER",
  ENERGY = "ENERGY",
}

export enum PokemonCardType {
  BASIC = "BASIC",
  STAGE1 = "STAGE1",
  STAGE2 = "STAGE2",
  LEVEL_UP = "LEVEL_UP",
  EX = "EX",
  EX_SMALL = "EX_SMALL",
  TERA = "TERA",
  MEGA = "MEGA",
  SP = "SP",
  LEGEND = "LEGEND",
  RESTORED = "RESTORED",
  BREAK = "BREAK",
  GX = "GX",
  TAG_TEAM = "TAG_TEAM",
  V = "V",
  VMAX = "VMAX",
  V_UNION = "V_UNION",
  VSTAR = "VSTAR",
  ANCIENT = "ANCIENT",
  FUTURE = "FUTURE",
}

export enum TrainerCardType {
  TRAINER_ITEM = "TRAINER_ITEM",
  POKEMON_TOOL = "POKEMON_TOOL",
  TRAINER_STADIUM = "TRAINER_STADIUM",
  TRAINER_SUPPORTER = "TRAINER_SUPPORTER",
  TECHNICAL_MACHINE = "TECHNICAL_MACHINE",
  ROCKETS_SECRET_MACHINE = "ROCKETS_SECRET_MACHINE",
  ACE_SPEC = "ACE_SPEC",
}

export enum EnergyCardType {
  BASIC = "BASIC",
  SPECIAL = "SPECIAL",
  ACE_SPEC = "ACE_SPEC",
}

export enum EnergyType {
  COLORLESS = "COLORLESS",
  GRASS = "GRASS",
  FIRE = "FIRE",
  WATER = "WATER",
  ELECTRIC = "LIGHTNING",
  PSYCHIC = "PSYCHIC",
  DARK = "DARKNESS",
  FAIRY = "FAIRY",
  FIGHTING = "FIGHTING",
  DRAGON = "DRAGON",
  STEEL = "METAL",
  SPECIAL = "SPECIAL",
}

export enum Rarity {
  COMMON = "COMMON",
  UNCOMMON = "UNCOMMON",
  RARE = "RARE",
  RARE_HOLO = "RARE_HOLO",
  RARE_HOLO_LVX = "RARE_HOLO_LVX",
  ULTRA_RARE = "ULTRA_RARE",
  RARE_RAINBOW = "RARE_RAINBOW",
  RADIANT_RARE = "RADIANT_RARE",
  SHINY_RARE = "SHINY_RARE",
  RARE_HOLO_EX = "RARE_HOLO_EX",
  RARE_PRIME = "RARE_PRIME",
  DOUBLE_RARE = "DOUBLE_RARE",
  PROMO = "PROMO",
  ILLUSTRATION_RARE = "ILLUSTRATION_RARE",
  SHINY_ULTRA_RARE = "SHINY_ULTRA_RARE",
  RARE_HOLO_GX = "RARE_HOLO_GX",
  LEGEND = "LEGEND",
  RARE_BREAK = "RARE_BREAK",
  AMAZING = "AMAZING",
  SPECIAL_ILLUSTRATION_RARE = "SPECIAL_ILLUSTRATION_RARE",
  ACE_SPEC_RARE = "ACE_SPEC_RARE",
}

export enum Format {
  STANDARD = "STANDARD",
  EXPANDED = "EXPANDED",
  LEGACY = "LEGACY",
}

export enum Series {
  EX = "EX",
  DIAMOND_PEARL = "DIAMOND_PEARL",
  PLATINUM = "PLATINUM",
  HEARTGOLD_SOULSILVER = "HEARTGOLD_SOULSILVER",
  BLACK_WHITE = "BLACK_WHITE",
  XY = "XY",
  SUN_MOON = "SUN_MOON",
  SWORD_SHIELD = "SWORD_SHIELD",
  SCARLET_VIOLET = "SCARLET_VIOLET",
}

export type Expansion = {
  id: number;
  series: string;
  name: string;
  cards: Card[];
};

export type ActionData = {
  success: boolean;
  data?: Expansion;
  err?: string;
};
