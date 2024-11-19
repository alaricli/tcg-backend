const Footer = () => {
  const currentYear = new Date().getFullYear();

  return (
    <div className="bg-gray-900 text-white p-2">
      <p className="text-center text-sm">
        Copyright © {currentYear} professorsresearchtcg.com, all rights reserved
      </p>
    </div>
  );
};

export default Footer;
