import { Form, useActionData, useNavigation } from "@remix-run/react";
import { useState } from "react";
import { ActionData } from "~/types";

const AddExpansionsForm = () => {
  const [series, setSeries] = useState("");
  const [name, setName] = useState("");
  const navigation = useNavigation();
  const isSubmitting = navigation.state === "submitting";
  const actionData = useActionData<ActionData>();

  const seriesOptions = ["SCARLET_VIOLET", "SWORD_SHIELD", "SUN_MOON"];

  const handleSubmit = (e: React.FormEvent) => {
    if (actionData?.success) {
      setSeries("");
      setName("");
    }
  };

  return (
    <div className="bg-white shadow-lg rounded-lg p-6">
      <h2 className="text-xl font-medium mb-4">Add New Expansion</h2>
      {actionData?.err && (
        <div className="mb-4 p-2 text-red-700 rounded">{actionData.err}</div>
      )}
      {actionData?.success && (
        <div className="mb-4 p-2 text-green-700 rounded">
          <p>Successfully Added Expansion</p>
        </div>
      )}
      <Form method="post" className="space-y-4" onSubmit={handleSubmit}>
        <div className="flex flex-col">
          <label htmlFor="series" className="mb-2">
            Series:
          </label>
          <select
            name="series"
            id="series"
            value={series}
            onChange={(e) => setSeries(e.target.value)}
            className="border border-gray-300 rounded-md p-2 focus:ring-2 focus:outline-none"
            required
          >
            {seriesOptions.map((option) => (
              <option key={option} value={option}>
                {option}
              </option>
            ))}
          </select>
        </div>
        <div className="flex flex-col">
          <label htmlFor="series" className="mb-2">
            Name:
          </label>
          <input
            type="text"
            name="name"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="name (eg. `Paldea Evolved`)"
            className="border border-gray-300 rounded-md p-2 focus:ring-2 focus:outline-none"
            required
          />
        </div>
        <button
          type="submit"
          disabled={isSubmitting}
          className="p-2 rounded-md shadow-sm border-2 border-black"
        >
          {isSubmitting ? "Adding..." : "Add New Expansion"}
        </button>
      </Form>
    </div>
  );
};

export default AddExpansionsForm;
