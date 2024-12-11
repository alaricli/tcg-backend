import { Card } from "@/types/types";
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
    <div className="min-h-screen bg-gray-100 p-6 flex justify-center items-center">
      <div className="max-w-4xl w-full bg-white shadow-lg rounded-lg overflow-hidden flex">
        {/* Left Section: Image */}
        <div className="w-1/3 p-4 flex items-center justify-center bg-gray-50">
          <img
            src={cardDetails.cardImages.large}
            alt={cardDetails.name}
            className="w-full h-auto max-w-xs rounded-md shadow-md"
          />
        </div>

        {/* Right Section: Details */}
        <div className="w-2/3 p-6 space-y-4">
          {/* Card Name */}
          <h1 className="text-2xl font-bold text-gray-800">
            {cardDetails.name}
          </h1>

          {/* Basic Information */}
          <div>
            <h2 className="text-lg font-semibold">Basic Information</h2>
            {(cardDetails.superType === "Pokémon" ||
              cardDetails.subTypes.includes("Fossil")) && (
              <p>
                <strong>HP:</strong> {cardDetails.hp}
              </p>
            )}
            <p>
              <strong>Artist:</strong> {cardDetails.artist}
            </p>
            <p>
              <strong>Rarity:</strong> {cardDetails.rarity}
            </p>
            <p>
              <strong>Expansion ID:</strong> {cardDetails.expansionId}
            </p>
          </div>

          {/* Energy Types */}
          {(cardDetails.superType === "Pokémon" ||
            cardDetails.superType === "Energy") && (
            <div>
              <h2 className="text-lg font-semibold">Energy Types</h2>
              <ul className="list-disc list-inside">
                {cardDetails.energyTypes.map((type) => (
                  <li key={type}>{type}</li>
                ))}
              </ul>
            </div>
          )}

          {/* Attacks */}
          {cardDetails.superType === "Pokémon" && (
            <div>
              <h2 className="text-lg font-semibold">Attacks</h2>
              {cardDetails.attacks.map((attack, index) => (
                <div
                  key={index}
                  className="p-4 border rounded-md bg-gray-50 my-2"
                >
                  <p>
                    <strong>Name:</strong> {attack.name}
                  </p>
                  <p>
                    <strong>Damage:</strong> {attack.damage}
                  </p>
                  <p>
                    <strong>Cost:</strong> {attack.cost}
                  </p>
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
        </div>
      </div>
    </div>
  );
}
