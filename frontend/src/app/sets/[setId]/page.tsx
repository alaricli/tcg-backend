"use client";

import { useState, useEffect, use } from "react";
import { Card } from "@/types/types";
import Image from "next/image";

async function fetchCards(
  setId: string,
  filters: Record<string, string>
): Promise<Card[]> {
  try {
    const queryParams = new URLSearchParams({ setId, ...filters }).toString();
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

// async function fetchPacks(
//   setId: string
// ): Promise<String[]> {
//   try {

//   }
// }

export default function SetPage({
  params: paramsPromise,
  searchParams: searchParamsPromise,
}: {
  params: Promise<{ setId: string }>;
  searchParams: Promise<{ data: string }>;
}) {
  const params = use(paramsPromise); // Unwrap params
  const searchParams = use(searchParamsPromise); // Unwrap searchParams

  const { setId: defaultSetId } = params;
  const { data } = searchParams;
  const setData = JSON.parse(decodeURIComponent(data));

  // States for filters and cards
  const [setId, setSetId] = useState(defaultSetId);
  const [filters, setFilters] = useState<Record<string, string>>({});
  const [cards, setCards] = useState<Card[]>([]);

  // Fetch cards when setId or filters change
  useEffect(() => {
    const fetchAndSetCards = async () => {
      const fetchedCards = await fetchCards(setId, filters);
      setCards(fetchedCards);
    };
    fetchAndSetCards();
  }, [setId, filters]);

  // Handler for updating filters
  // const updateFilter = (filterKey: string, filterValue: string) => {
  //   setFilters((prevFilters) => ({
  //     ...prevFilters,
  //     [filterKey]: filterValue,
  //   }));
  // };

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

  return (
    <div className="min-h-screen">
      <header className="bg-gradient-to-r from-indigo-500 to-pink-400 shadow-md p-6 flex items-center justify-between">
        {setData.setLogo && (
          <Image
            src={setData.setLogo}
            alt={`${setData.name} logo`}
            className="object-cover"
            height={100}
            width={100}
          />
        )}
        <div className="flex space-y-2 space-x-2">
          <h1 className="text-3xl font-semibold text-white">
            {setData.setName}
          </h1>
          <p className="text-gray-100">({setData.setCode})</p>
        </div>
        <div className="flex flex-col text-white">
          <p>Set Total: {setData.setTotal}</p>
          <p>Release Date: {setData.setReleaseDate}</p>
        </div>
      </header>

      {/* Filter Section */}
      <div className="p-6 bg-white shadow-md flex">
        <label className="block mb-2 text-sm font-medium text-gray-700">
          Select Set ID:
        </label>
        <select
          value={setId}
          onChange={(e) => setSetId(e.target.value)}
          className="p-2 border rounded-md"
        >
          <option value="">All</option>
          <option value="A1">Genetic Apex</option>
          <option value="P-A">Promo A</option>
        </select>

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
      </div>

      {/* Cards Section */}
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 2xl:grid-cols-6 gap-6 p-6">
        {cards.map((card) => (
          <div
            key={card.id}
            className="rounded-lg p-4 w-64 flex flex-col items-center shadow-md"
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
          </div>
        ))}
      </div>
    </div>
  );
}
