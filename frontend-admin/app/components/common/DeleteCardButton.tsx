import { useFetcher } from "@remix-run/react";

interface DeleteCardButtonProps {
  cardId: number;
}

const DeleteCardButton: React.FC<DeleteCardButtonProps> = ({ cardId }) => {
  const fetcher = useFetcher();

  const handleDelete = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/api/card/delete/${cardId}`,
        {
          method: "DELETE",
        }
      );

      if (!response.ok) {
        throw new Error("Failed to delete card.");
      }
    } catch (err) {
      console.error("Delete failed", err);
    }
  };

  return (
    <button onClick={handleDelete} className="text-red-700 hover:underline">
      delete
    </button>
  );
};

export default DeleteCardButton;
