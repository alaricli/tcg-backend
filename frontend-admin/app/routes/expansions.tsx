import AddExpansionsForm from "~/components/forms/addExpansionsForm";

const ExpansionsManagementPage = () => {
  return (
    <div className="h-screen items-center bg-gray-100 p-4">
      <h1 className="text-3xl font-semibold p-4">Expansions Management</h1>
      <div className="w-full max-w-lg flex flex-col">
        <AddExpansionsForm />
        {/* see all current expansions + remove, click into it to see cards */}
        <div className="w-full max-w-lg bg-white shadow-lg rounded-lg mt-4 p-6">
          <h2 className="text-xl font-medium mb-4">All Expansions</h2>
          <div>
            <p>use getAll API to display all expansions here</p>
            <p>use getbyID API to click into expansion to go to its page</p>
            <p>use deletebyID API to delete expansion on X butto click</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ExpansionsManagementPage;
