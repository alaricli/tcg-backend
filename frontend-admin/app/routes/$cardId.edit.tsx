import { LoaderFunctionArgs } from "@remix-run/node";
import { useLoaderData } from "@remix-run/react";
import { useState } from "react";
import DeleteCardButton from "~/components/common/DeleteCardButton";
import {
  EnergyCardType,
  EnergyType,
  Format,
  PokemonCardType,
  Rarity,
  TrainerCardType,
} from "~/types";

export const loader = async ({ params }: LoaderFunctionArgs) => {
  const cardId = params.cardId;
  if (!cardId) {
    throw new Response("Not Found", { status: 404 });
  }
  // Add your data fetching logic here
  const response = await fetch(`http://localhost:8080/api/card/get/${cardId}`);
  if (!response.ok) {
    throw new Response("Error fetching card details", {
      status: response.status,
    });
  }

  const cardData = await response.json();
  return { cardData, cardId };
};

export default function EditCard() {
  const { cardData, cardId } = useLoaderData<typeof loader>();
  const [formData, setFormData] = useState(cardData);

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSave = async () => {
    try {
      const { id, price, ...updates } = formData;
      const response = await fetch(
        `http://localhost:8080/api/card/put/${cardId}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(updates),
        }
      );

      if (!response.ok) {
        throw new Error("Failed to save changes.");
      }

      const updatedCard = await response.json();
      alert("Changes saved successfully!");
      console.log(updatedCard);
    } catch (error) {
      console.error(error);
      alert("An error occurred while saving changes.");
    }
  };
  return (
    <div className="p-4 border rounded-lg shadow min-h-screen">
      <div className="flex items-start space-x-4">
        {/* Left side: Image */}
        <div className="flex-shrink-0">
          <img
            src={formData.picUrl || "http://example.com/pikachu.png"}
            alt={formData.name || "Card image"}
            className="w-full h-auto max-w-sm rounded mb-4"
          />
        </div>
        {/* Right side: Details */}
        <div className="flex-grow">
          <div className="flex items-center space-x-4 mb-2">
            <p>
              <strong>Name:</strong> {cardData.name || "Unknown"}
            </p>
            <input
              type="text"
              name="name"
              value={formData.name || ""}
              onChange={handleChange}
              className="w-full border rounded px-2 py-1 max-w-sm"
            />
          </div>

          <p>
            <strong>ID:</strong> {cardData.id}
          </p>

          <div className=" space-x-4 mb-2">
            <p>
              <strong>Image:</strong> {formData.picUrl || "N/A"}
            </p>
            <input
              type="text"
              name="picUrl"
              value={formData.picUrl || ""}
              onChange={handleChange}
              className="w-full border rounded px-2 py-1 max-w-4xl"
            />
          </div>

          <div className="flex items-center space-x-4 mb-2">
            <p>
              <strong>Artist:</strong> {cardData.artist || "N/A"}
            </p>
            <input
              type="text"
              name="artist"
              value={formData.artist || ""}
              onChange={handleChange}
              className="w-full border rounded px-2 py-1 max-w-sm"
            />
          </div>

          {formData.cardType === "POKEMON" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>HP:</strong> {cardData.hp || "N/A"}
              </p>
              <input
                type="number"
                name="hp"
                value={formData.hp || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              />
            </div>
          )}

          {formData.cardType === "POKEMON" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Retreat Cost:</strong> {cardData.retreatCost || "N/A"}
              </p>
              <input
                type="number"
                name="retreatCost"
                value={formData.retreatCost || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              />
            </div>
          )}

          {formData.cardType === "POKEMON" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Ability:</strong> {cardData.ability ? "Yes" : "No"}
              </p>
              <select
                name="ability"
                value={formData.ability ? "true" : "false"}
                onChange={(e) =>
                  setFormData({
                    ...formData,
                    ability: e.target.value === "true",
                  })
                }
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                <option value="true">Yes</option>
                <option value="false">No</option>
              </select>
            </div>
          )}

          <div className="flex items-center space-x-4 mb-2">
            <p>
              <strong>Rarity:</strong> {cardData.rarity}
            </p>
            <select
              name="rarity"
              value={formData.rarity || ""}
              onChange={handleChange}
              className="w-full border rounded px-2 py-1 max-w-sm"
            >
              {Object.values(Rarity).map((rarity) => (
                <option key={rarity} value={rarity}>
                  {rarity}
                </option>
              ))}
            </select>
          </div>

          <div className="flex items-center space-x-4 mb-2">
            <p>
              <strong>Price:</strong>{" "}
              {`$${cardData.price?.toFixed(2) || "N/A"}`}
            </p>
          </div>

          {formData.cardType === "POKEMON" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Pokemon Card Type:</strong>{" "}
                {cardData.pokemonCardTypes.join(", ") || "N/A"}
              </p>
              <select
                name="pokemonCardType"
                value={formData.pokemonCardType || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                {Object.values(PokemonCardType).map((pokemonCardType) => (
                  <option key={pokemonCardType} value={pokemonCardType}>
                    {pokemonCardType}
                  </option>
                ))}
              </select>
            </div>
          )}

          {formData.cardType === "TRAINER" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Trainer Card Type:</strong>{" "}
                {cardData.trainerCardType || "N/A"}
              </p>
              <select
                name="trainerCardType"
                value={formData.trainerCardType || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                {Object.values(TrainerCardType).map((trainerCardType) => (
                  <option key={trainerCardType} value={trainerCardType}>
                    {trainerCardType}
                  </option>
                ))}
              </select>
            </div>
          )}

          {formData.cardType === "ENERGY" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Energy Card Type:</strong>{" "}
                {cardData.energyCardType || "N/A"}
              </p>
              <select
                name="energyCardType"
                value={formData.energyCardType || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                {Object.values(EnergyCardType).map((energyCardType) => (
                  <option key={energyCardType} value={energyCardType}>
                    {energyCardType}
                  </option>
                ))}
              </select>
            </div>
          )}

          {(formData.cardType === "ENERGY" ||
            formData.cardType === "POKEMON") && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Energy Type:</strong> {cardData.energyType || "N/A"}
              </p>
              <select
                name="energyType"
                value={formData.energyType || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                {Object.values(EnergyType).map((energyType) => (
                  <option key={energyType} value={energyType}>
                    {energyType}
                  </option>
                ))}
              </select>
            </div>
          )}

          {formData.cardType === "POKEMON" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Attack Energy Type:</strong>{" "}
                {cardData.attackEnergyType || "N/A"}
              </p>
              <select
                name="attackEnergyType"
                value={formData.attackEnergyType || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                {Object.values(EnergyType).map((energyType) => (
                  <option key={energyType} value={energyType}>
                    {energyType}
                  </option>
                ))}
              </select>
            </div>
          )}

          {formData.cardType === "POKEMON" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Weakness:</strong> {cardData.weakness || "N/A"}
              </p>
              <select
                name="weakness"
                value={formData.weakness || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                {Object.values(EnergyType).map((energyType) => (
                  <option key={energyType} value={energyType}>
                    {energyType}
                  </option>
                ))}
              </select>
            </div>
          )}

          {formData.cardType === "POKEMON" && (
            <div className="flex items-center space-x-4 mb-2">
              <p>
                <strong>Resistance:</strong> {cardData.resistance || "N/A"}
              </p>
              <select
                name="resistance"
                value={formData.resistance || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1 max-w-sm"
              >
                {Object.values(EnergyType).map((energyType) => (
                  <option key={energyType} value={energyType}>
                    {energyType}
                  </option>
                ))}
              </select>
            </div>
          )}

          <div className="flex items-center space-x-4 mb-2">
            <p>
              <strong>Format:</strong> {cardData.format || "N/A"}
            </p>
            <select
              name="format"
              value={formData.format || ""}
              onChange={handleChange}
              className="w-full border rounded px-2 py-1 max-w-sm"
            >
              {Object.values(Format).map((format) => (
                <option key={format} value={format}>
                  {format}
                </option>
              ))}
            </select>
          </div>

          <div className="flex items-center space-x-4 mb-2">
            <p>
              <strong>Card Type:</strong> {formData.cardType || "N/A"}{" "}
            </p>
          </div>

          <div className="flex items-center space-x-4 mb-2">
            <p>
              <strong>Expansion:</strong> {cardData.expansionName || "N/A"}{" "}
            </p>
          </div>
        </div>
      </div>
      <button
        onClick={handleSave}
        className="mr-2 bg-blue-500 text-white rounded px-4 py-2"
      >
        save changes
      </button>
      <DeleteCardButton cardId={Number(cardId)} />
    </div>
  );
}
