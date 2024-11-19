import { useFetcher } from "@remix-run/react";

type DeleteButtonProps = {
  expansionId: number;
  onSuccess?: () => void;
};

const DeleteButton: React.FC<DeleteButtonProps> = ({
  expansionId,
  onSuccess,
}) => {
  const fetcher = useFetcher();

  const handleDelete = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/api/expansion/delete/${expansionId}`,
        {
          method: "DELETE",
        }
      );

      if (!response.ok) {
        throw new Error("Failed to delete expansion.");
      }

      if (onSuccess) onSuccess();
    } catch (err) {
      console.error("Delete failed", err);
      alert("Failed to delete expansion");
    }
  };

  return (
    <button onClick={handleDelete} className="text-red-700 hover:underline">
      delete
    </button>
  );
};

export default DeleteButton;
