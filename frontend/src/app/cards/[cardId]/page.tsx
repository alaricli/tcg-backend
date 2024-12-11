import { getEnergySymbol } from "@/app/utils/GetEnergySymbol";
import { Card } from "@/types/types";
import Image from "next/image";

async function fetchCardDetails(cardId: string): Promise<Card | null> {
  try {
    const response = await fetch(
      `http://localhost:8080/api/get/card/${cardId}`
    );

    if (!response.ok) {
      throw new Error("Failed to fetch card details");
    }

    return await response.json();
  } catch (error) {
    console.error("Error ", error);
    return null;
  }
}

export default async function CardPage({
  params: paramsPromise,
}: {
  params: Promise<{ cardId: string }>;
}) {
  const params = await paramsPromise;
  const { cardId } = params;

  const cardDetails = await fetchCardDetails(cardId);

  if (!cardDetails) {
    return <div className="min-h-screen">404: Card Not Found</div>;
  }

  return (
    <div className="min-w-screen min-h-screen shadow-lg rounded-lg overflow-hidden flex">
      {/* Left Section: Image */}
      <div className="w-1/3 p-4 flex items-center justify-center">
        <Image
          src={cardDetails.cardImages.large}
          alt={cardDetails.name}
          className="w-full h-auto max-w-xs rounded-md shadow-md"
          width={250}
          height={250}
        />
      </div>

      {/* Right Section: Details */}
      <div className="w-1/3 p-6 mt-20 space-y-4">
        {/* Card Name */}
        <h1 className="text-2xl font-bold">
          {cardDetails.name}
          {(cardDetails.superType === "Pokémon" ||
            cardDetails.superType === "Energy") && (
            <div>
              <p className="energy-icon">
                {getEnergySymbol(cardDetails.mainType)}
              </p>
            </div>
          )}{" "}
          {(cardDetails.superType === "Pokémon" ||
            cardDetails.subTypes.includes("Fossil")) && (
            <p>
              <strong>HP:</strong> {cardDetails.hp}
            </p>
          )}
        </h1>

        {/* Shared Basic Information */}
        <div>
          <p>
            <strong>Rarity:</strong> {cardDetails.rarity}
          </p>
          <p>
            <strong>Expansion:</strong> {cardDetails.expansionId}
          </p>
        </div>

        {/* Attacks */}
        {cardDetails.superType === "Pokémon" && (
          <div>
            {cardDetails.hasAbility && (
              <div>
                <h2>Ability:</h2>
                {cardDetails.ability}
              </div>
            )}
            <h2 className="text-lg font-semibold">Attacks:</h2>
            {cardDetails.attacks.map((attack, index) => (
              <div key={index} className="p-4 border rounded-md my-2">
                <p>
                  <strong>Name:</strong> {attack.name}
                </p>
                <p>
                  <strong>Damage:</strong> {attack.damage}
                </p>
                <div className="flex space-x-2">
                  <strong>Cost:</strong>
                  {attack.cost.split(",").map((cost, index) => (
                    <span key={index} className="energy-icon">
                      {getEnergySymbol(cost)}
                    </span>
                  ))}
                </div>
              </div>
            ))}
          </div>
        )}

        {/* Trainer Card Text */}
        {cardDetails.superType === "Trainer" && (
          <div className="p-6 bg-blue-100 rounded-md shadow-md">
            <h2 className="text-xl font-bold text-blue-800">Text</h2>
            <p className="text-lg mt-4 text-gray-700">
              <strong className="block mb-2"></strong>{" "}
              {cardDetails.trainerCardText}
            </p>
          </div>
        )}

        {/* Pokemon Basic Information */}
        {cardDetails.superType === "Pokémon" && (
          <div>
            <p>
              <strong>Weakness:</strong>
              <p className="energy-icon">
                {getEnergySymbol(cardDetails.weakness[0])}
              </p>
            </p>
            <p>
              <strong>Resistance:</strong> {cardDetails.resistance}
            </p>
            <p>
              <strong>Retreat Cost</strong> {cardDetails.retreatCost}
            </p>
          </div>
        )}
      </div>
    </div>
  );
}
