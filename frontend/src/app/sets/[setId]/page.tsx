"use client";

import { useState, useEffect, use } from "react";
import { Card, Expansion } from "@/types/types";
import Image from "next/image";
import Link from "next/link";

async function fetchCards(
  setId: string,
  filters: Record<string, string>
): Promise<Card[]> {
  try {
    const queryParams = new URLSearchParams({
      ...(setId && { setId }),
      ...filters,
    }).toString();
    const response = await fetch(
      `http://localhost:8080/api/get/cards?${queryParams}`
    );

    if (!response.ok) {
      throw new Error("Failed to fetch cards");
    }

    return response.json();
  } catch (error) {
    console.error("Error fetching cards: ", error);
    return [];
  }
}

async function fetchExpansionDetails(setId: string): Promise<Expansion | null> {
  if (!setId || setId == "" || setId == "all") {
    return {
      id: "",
      series: "",
      name: "All Cards",
      expansionImages: {
        symbol: "",
        logo: "/tcgpocketlogo.png",
      },
      legalities: null,
      printedTotal: 0,
      total: 0,
      expansionCode: "",
      releaseDate: "",
    };
  }

  try {
    const response = await fetch(
      `http://localhost:8080/api/get/expansion/${setId}`
    );

    if (!response.ok) {
      throw new Error("Failed to fetch expansion details");
    }

    return response.json();
  } catch (error) {
    console.error("Error fetching expansion details: ", error);
    return null;
  }
}

export default function SetPage({
  params: paramsPromise,
}: {
  params: Promise<{ setId: string }>;
}) {
  const params = use(paramsPromise || { setId: "" });

  const { setId: initialSetId = "" } = params;

  const [setId, setSetId] = useState(initialSetId);
  const [filters, setFilters] = useState<Record<string, string>>({});
  const [cards, setCards] = useState<Card[]>([]);
  const [expansionDetails, setExpansionDetails] = useState<Expansion | null>(
    null
  );
  const [searchText, setSearchText] = useState("");
  const [showFilters, setShowFilters] = useState(false);

  useEffect(() => {
    const fetchAndSetCards = async () => {
      const fetchedCards = await fetchCards(setId, filters);
      setCards(fetchedCards);
    };
    fetchAndSetCards();
  }, [setId, filters]);

  useEffect(() => {
    const fetchAndSetExpansionDetails = async () => {
      const fetchedDetails = await fetchExpansionDetails(setId);
      setExpansionDetails(fetchedDetails);
    };
    fetchAndSetExpansionDetails();
  }, [setId]);

  const updateFilter = (filterKey: string, filterValue: string) => {
    setFilters((prevFilters) => {
      const updatedFilters = { ...prevFilters };
      if (!filterValue || filterKey === "All") {
        delete updatedFilters[filterKey]; // Remove key if value is cleared
      } else {
        updatedFilters[filterKey] = filterValue;
      }
      return updatedFilters;
    });
  };

  const packOptions: Record<string, { value: string; label: string }[]> = {
    A1: [
      { value: "A1-1", label: "Genetic Apex: Mewtwo Pack" },
      { value: "A1-2", label: "Genetic Apex: Charizard Pack" },
      { value: "A1-3", label: "Genetic Apex: Pikachu Pack" },
    ],
    "P-A": [
      { value: "PA1-1", label: "Promo Pack A Series Vol.1" },
      { value: "PA1-2", label: "Promo Pack A Series Vol.2" },
    ],
    default: [
      { value: "A1-1", label: "Genetic Apex: Mewtwo Pack" },
      { value: "A1-2", label: "Genetic Apex: Charizard Pack" },
      { value: "A1-3", label: "Genetic Apex: Pikachu Pack" },
      { value: "PA1-1", label: "Promo Pack A Series Vol.1" },
      { value: "PA1-2", label: "Promo Pack A Series Vol.2" },
      { value: "M", label: "Missions" },
      { value: "Shop", label: "Shop" },
      { value: "WP", label: "Wonder Pick" },
    ],
  };

  const getPackOptions = (setId: string) => {
    if (packOptions[setId]) {
      return packOptions[setId];
    }
    return packOptions.default;
  };

  return (
    <div className="min-h-screen">
      <header className="bg-gradient-to-r from-indigo-500 to-pink-400 shadow-md py-4 px-6 flex items-center justify-between w-full">
        <div className="flex items-center h-24 w-24 overflow-hidden">
          {expansionDetails?.expansionImages?.logo && (
            <Image
              src={expansionDetails.expansionImages.logo}
              alt={`${expansionDetails.name} logo`}
              className="object-contain w-full h-full"
              height={100}
              width={100}
            />
          )}
        </div>
        <div className="absolute left-1/2 transform -translate-x-1/2 text-center">
          <h1 className="text-3xl font-semibold text-white">
            {expansionDetails?.name || "Loading..."}
          </h1>
          <p className="text-gray-100">{expansionDetails?.expansionCode}</p>
        </div>
        <div className="text-white text-right">
          {expansionDetails?.total !== undefined &&
            expansionDetails.total > 0 && (
              <p>Set Total: {expansionDetails.total}</p>
            )}
          {expansionDetails?.releaseDate && (
            <p>Release Date: {expansionDetails.releaseDate}</p>
          )}
        </div>
      </header>

      <div className="flex">
        <button
          onClick={() => setShowFilters(!showFilters)}
          className="w-full bg-gray-700 text-white py-2"
        >
          Toggle Filters
          <div>{showFilters ? <span>↑</span> : <span>↓</span>}</div>
        </button>
      </div>

      {/* Filter Section */}
      {showFilters && (
        <div className="p-6 bg-white shadow-md grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-4">
          <label className="block mb-2 text-sm font-medium text-gray-700">
            Select Set ID:
          </label>
          <select
            value={setId}
            onChange={(e) => {
              updateFilter("expansionId", e.target.value);
              setSetId(e.target.value);
            }}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="A1">Genetic Apex</option>
            <option value="P-A">Promo A</option>
          </select>

          <label className="block mb-2 text-sm font-medium text-gray-700">
            Select Pack:
          </label>
          <select
            onChange={(e) => updateFilter("packId", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            {getPackOptions(setId).map((option) => (
              <option key={option.value} value={option.value}>
                {option.label}
              </option>
            ))}
          </select>

          <label className="block mb-2 text-sm font-medium text-gray-700">
            Search:
          </label>
          <div>
            <input
              placeholder="search..."
              className="border p-2 rounded-md"
              value={searchText}
              onChange={(e) => setSearchText(e.target.value)}
            />
            <button
              onClick={() => updateFilter("searchText", searchText)}
              className="bg-blue-500 p-2"
            >
              Search
            </button>
          </div>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Rarity:
          </label>
          <select
            onChange={(e) => updateFilter("rarity", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="Common">Common</option>
            <option value="Uncommon">Uncommon</option>
            <option value="Rare">Rare</option>
            <option value="Double Rare">Double Rare</option>
            <option value="Art Rare">Art Rare</option>
            <option value="Super Rare">Super Rare</option>
            <option value="Special Art Rare">Special Art Rare</option>
            <option value="Immersive Rare">Immersive Rare</option>
            <option value="Crown Rare">Crown Rare</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Type:
          </label>
          <select
            onChange={(e) => updateFilter("energyType", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="Fire">Fire</option>
            <option value="Water">Water</option>
            <option value="Grass">Grass</option>
            <option value="Lightning">Lightning</option>
            <option value="Psychic">Psychic</option>
            <option value="Fighting">Fighting</option>
            <option value="Darkness">Darkness</option>
            <option value="Metal">Metal</option>
            <option value="Fairy">Fairy</option>
            <option value="Dragon">Dragon</option>
            <option value="Colorless">Colorless</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Weakness:
          </label>
          <select
            onChange={(e) => updateFilter("weakness", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="Fire">Fire</option>
            <option value="Water">Water</option>
            <option value="Grass">Grass</option>
            <option value="Lightning">Lightning</option>
            <option value="Psychic">Psychic</option>
            <option value="Fighting">Fighting</option>
            <option value="Darkness">Darkness</option>
            <option value="Metal">Metal</option>
            <option value="Fairy">Fairy</option>
            <option value="Dragon">Dragon</option>
            <option value="Colorless">Colorless</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Ability:
          </label>
          <select
            onChange={(e) => updateFilter("hasAbility", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="true">Yes</option>
            <option value="false">No</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Rule Box (ex):
          </label>
          <select
            onChange={(e) => updateFilter("hasRuleBox", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="true">Yes</option>
            <option value="false">No</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Card Category:
          </label>
          <select
            onChange={(e) => updateFilter("superType", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="Pokémon">Pokémon</option>
            <option value="Trainer">Trainer</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Card Type:
          </label>
          <select
            onChange={(e) => updateFilter("subType", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="Basic">Basic</option>
            <option value="Stage 1">Stage 1</option>
            <option value="Stage 2">Stage 2</option>
            <option value="Item">Item</option>
            <option value="ex">ex</option>
            <option value="Supporter">Supporter</option>
            <option value="Fossil">Fossil</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Filter by Retreat Cost:
          </label>
          <select
            onChange={(e) => updateFilter("retreatCost", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">All</option>
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Sort By:
          </label>
          <select
            onChange={(e) => updateFilter("sortBy", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">Default (id)</option>
            <option value="name">Name</option>
            <option value="nationalDexNumber">Nat Dex Number</option>
            <option value="rarity">Rarity</option>
            <option value="type">Energy Type</option>
            <option value="superType">Card Type</option>
          </select>

          <label className="block mt-4 mb-2 text-sm font-medium text-gray-700">
            Sort Direction:
          </label>
          <select
            onChange={(e) => updateFilter("sortDirection", e.target.value)}
            className="p-2 border rounded-md"
          >
            <option value="">Ascending</option>
            <option value="DESC">Descending</option>
          </select>
        </div>
      )}

      {/* Cards Section */}
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 2xl:grid-cols-6 gap-6 p-6">
        {cards.map((card) => (
          <div
            key={card.id}
            className="rounded-lg p-4 w-64 flex flex-col items-center shadow-md"
          >
            <Link
              href={{
                pathname: `/cards/${card.id}`,
              }}
            >
              <div>
                <Image
                  src={card.cardImages.small}
                  alt={`${card.name} image`}
                  className="object-cover rounded-lg"
                  height={250}
                  width={250}
                />
                <div className="flex justify-between w-full p-4">
                  <p className="text-lg font-semibold">{card.name}</p>
                  <p className="text-sm text-gray-500">{card.id}</p>
                </div>
              </div>
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
}
