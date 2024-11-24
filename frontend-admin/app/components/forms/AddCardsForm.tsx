import { Form, useNavigation } from "@remix-run/react";
import { useState } from "react";

const AddCardsForm = () => {
  const [selectedFile, setSelectedFile] = useState<File | null>(null);
  const [isSubmitting, setIsSubmitting] = useState(false);

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files && e.target.files.length > 0) {
      setSelectedFile(e.target.files[0]);
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!selectedFile) return;

    setIsSubmitting(true);
    const formData = new FormData();
    formData.append("file", selectedFile);

    try {
      const response = await fetch("http://localhost:8080/api/card/import", {
        method: "POST",
        body: formData,
      });

      if (!response.ok) {
        console.error("Failed to upload:", response.statusText);
        alert("Failed to upload:" + response.statusText);
      } else {
        console.log("File uploaded successfully");
        alert("File uploaded successfully");
      }
    } catch (error) {
      console.error("Error uploading file:", error);
      alert(error);
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div>
      <h2>Upload Cards Data</h2>
      <p>
        Upload a .csv file containing Pokémon card data. Ensure the file is
        properly formatted.
      </p>
      <form onSubmit={handleSubmit} className="space-y-4">
        {/* File Input */}
        <div className="flex flex-col">
          <label
            htmlFor="file"
            className="text-sm font-medium text-gray-700 mb-2"
          >
            Select a CSV File
          </label>
          <input
            type="file"
            id="file"
            name="file"
            accept=".csv"
            onChange={handleFileChange}
            className="border border-gray-300 rounded-md p-2 focus:ring-2 focus:ring-blue-500 focus:outline-none"
            required
          />
        </div>

        {/* Submit Button */}
        <button
          type="submit"
          disabled={!selectedFile || isSubmitting}
          className={`w-full py-2 rounded-md shadow-sm font-medium text-white ${
            isSubmitting
              ? "bg-gray-400 cursor-not-allowed"
              : "bg-blue-600 hover:bg-blue-700 focus:ring-2 focus:ring-blue-500"
          }`}
        >
          {isSubmitting ? "Uploading..." : "Upload Cards"}
        </button>
      </form>
    </div>
  );
};

export default AddCardsForm;
