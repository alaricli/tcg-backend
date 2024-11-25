import { LoaderFunctionArgs } from "@remix-run/node";
import { useLoaderData } from "@remix-run/react";
import { useState } from "react";

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
  const [isEditing, setIsEditing] = useState(false);
  const [formData, setFormData] = useState(cardData);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSave = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/api/card/patch/${formData.id}`,
        {
          method: "PATCH",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(formData),
        }
      );

      if (!response.ok) {
        throw new Error("Failed to save changes.");
      }

      alert("Changes saved successfully!");
      setIsEditing(false);
    } catch (error) {
      console.error(error);
      alert("An error occurred while saving changes.");
    }
  };
  return (
    <div className="p-4 border rounded-lg shadow">
      <h2 className="text-xl font-bold mb-2 text-center">
        {isEditing ? (
          <input
            type="text"
            name="name"
            value={formData.name || ""}
            onChange={handleChange}
            className="w-full border rounded px-2 py-1"
          />
        ) : (
          formData.name || "Unknown"
        )}
      </h2>
      <div className="flex items-start space-x-4">
        {/* Left side: Image */}
        <div className="flex-shrink-0">
          <img
            src={formData.picUrl || "http://example.com/pikachu.png"}
            alt={formData.name || "Card image"}
            className="w-full h-auto max-w-xs rounded mb-4"
          />
        </div>
        {/* Right side: Details */}
        <div className="flex-grow">
          <p>
            <strong>ID:</strong> {formData.id}
          </p>
          <p>
            <strong>Artist:</strong>{" "}
            {isEditing ? (
              <input
                type="text"
                name="artist"
                value={formData.artist || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1"
              />
            ) : (
              formData.artist || "N/A"
            )}
          </p>
          <p>
            <strong>HP:</strong>{" "}
            {isEditing ? (
              <input
                type="number"
                name="hp"
                value={formData.hp || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1"
              />
            ) : (
              formData.hp || "N/A"
            )}
          </p>
          <p>
            <strong>Rarity:</strong>{" "}
            {isEditing ? (
              <select
                name="rarity"
                value={formData.rarity || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1"
              >
                <option value="COMMON">Common</option>
                <option value="RARE">Rare</option>
                <option value="ULTRA_RARE">Ultra Rare</option>
              </select>
            ) : (
              formData.rarity
            )}
          </p>
          <p>
            <strong>Price:</strong>{" "}
            {isEditing ? (
              <input
                type="number"
                step="0.01"
                name="price"
                value={formData.price || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1"
              />
            ) : (
              `$${formData.price?.toFixed(2) || "N/A"}`
            )}
          </p>
          <p>
            <strong>Type:</strong>{" "}
            {formData.pokemonCardType ||
              formData.trainerCardType ||
              formData.energyCardType ||
              "N/A"}
          </p>
          <p>
            <strong>Energy Type:</strong> {formData.energyType || "N/A"}
          </p>
          <p>
            <strong>Format:</strong> {formData.format || "N/A"}
          </p>
          <p>
            <strong>Expansion:</strong>{" "}
            {isEditing ? (
              <input
                type="text"
                name="expansionName"
                value={formData.expansionName || ""}
                onChange={handleChange}
                className="w-full border rounded px-2 py-1"
              />
            ) : (
              formData.expansionName || "N/A"
            )}
          </p>
        </div>
      </div>
      {/* Actions */}
      <div className="flex justify-end space-x-2 mt-4">
        {isEditing ? (
          <>
            <button
              onClick={() => setIsEditing(false)}
              className="px-4 py-2 text-white bg-gray-500 rounded hover:bg-gray-600"
            >
              Cancel
            </button>
            <button
              onClick={handleSave}
              className="px-4 py-2 text-white bg-indigo-600 rounded hover:bg-indigo-700"
            >
              Save Changes
            </button>
          </>
        ) : (
          <button
            onClick={() => setIsEditing(true)}
            className="px-4 py-2 text-white bg-indigo-600 rounded hover:bg-indigo-700"
          >
            Edit
          </button>
        )}
      </div>
    </div>
  );
}
