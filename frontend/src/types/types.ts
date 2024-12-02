export interface Expansion {
  id: string;
  series: string;
  name: string;
  expansionImages: {
    symbol: string;
    logo: string;
  };
  legalities: string | null;
  printedTotal: number;
  total: number;
  expansionCode: string;
  releaseDate: string | null;
}

export interface Card {
  id: string;
  name: string;
  hp: number;
  artist: string;
  regulationMark: string;
  price: null | number;
  marketPrice: null | number;
  rules: string[];
  expansionId: string;
  cardNumber: number;
  rarity: string;
  superType: string;
  subTypes: string[];
  cardImages: {
    small: string;
    large: string;
  };
  legalities: null | object;
  pullRates: null | object;
  energyTypes: string[];
  attacks: null | object;
  attackEnergyTypes: string[];
  weakness: string[];
  resistance: string[];
  foundInPacks: string[];
  nationalPokedexNumber: number;
  retreatCost: number;
  hasRuleBox: boolean;
  hasAbility: boolean;
  ability: null | string;
  trainerCardText: string;
  dustCost: number;
  description: null | string;
  pocket: boolean;
}
