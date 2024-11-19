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
  pokemonCardType: PokemonCardType | null;
  trainerCardType: TrainerCardType | null;
  energyCardType: EnergyCardType | null;
  energyType: EnergyType | null;
  attackEnergyType: EnergyType | null;
  weakness: EnergyType | null;
  resistance: EnergyType | null;
  rarity: Rarity | null;
  format: Format | null;
  expansionName: string | null;
};

export enum CardType {
  BASIC = "BASIC",
  STAGE1 = "STAGE1",
  STAGE2 = "STAGE2",
}

export enum PokemonCardType {
  BASIC = "BASIC",
  STAGE1 = "STAGE1",
  STAGE2 = "STAGE2",
}

export enum TrainerCardType {
  TRAINER_ITEM = "TRAINER_ITEM",
  TRAINER_SUPPORTER = "TRAINER_SUPPORTER",
  TRAINER_STADIUM = "TRAINER_STADIUM",
}

export enum EnergyCardType {
  BASIC = "BASIC",
  SPECIAL = "SPECIAL",
}

export enum EnergyType {
  COLORLESS = "COLORLESS",
  GRASS = "GRASS",
  FIRE = "FIRE",
  WATER = "WATER",
  ELECTRIC = "ELECTRIC",
  PSYCHIC = "PSYCHIC",
  DARK = "DARK",
  FAIRY = "FAIRY",
  FIGHTING = "FIGHTING",
  DRAGON = "DRAGON",
}

export enum Rarity {
  COMMON = "COMMON",
  UNCOMMON = "UNCOMMON",
  RARE = "RARE",
}

export enum Format {
  STANDARD = "STANDARD",
  EXPANDED = "EXPANDED",
  LEGACY = "LEGACY",
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
