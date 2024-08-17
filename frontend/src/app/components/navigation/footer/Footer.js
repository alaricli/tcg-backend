const Footer = () => {
  return (
    <footer
      style={{
        background: '#f0f0f0',
        textAlign: 'center',
        padding: '20px',
        marginTop: '20px',
      }}
    >
      <p>Copyright © {new Date().getFullYear()} Your Company Name</p>
      <p>
        Follow us on
        <a
          href="https://twitter.com"
          target="_blank"
          rel="noopener noreferrer"
          style={{ marginLeft: '5px' }}
        >
          Twitter
        </a>
      </p>
    </footer>
  );
};

export default Footer;
