# web-browser
For a user, a search engine is just a website that provides links to other websites. However, to connect to a website's server and display its web pages, a user must have a web browser installed.
Web browsers are used on a range of devices, including desktops, laptops, tablets, and smartphones.

FUNCTION
The purpose of a web browser is to fetch information resources from the Web and display them on a user's device.

This process begins when the user inputs a Uniform Resource Locator (URL), such as https://WWW.Google.com, into the browser. Virtually all URLs on the Web start with either http: or https: which means the browser will retrieve them with the Hypertext Transfer Protocol (HTTP). In the case of https:, the communication between the browser and the web server is encrypted for the purposes of security and privacy.

Once a web page has been retrieved, the browser's rendering engine displays it on the user's device. This includes image and video formats supported by the browser.

Web pages usually contain hyperlinks to other pages and resources. Each link contains a URL, and when it is clicked or tapped, the browser navigates to the new resource. Thus the process of bringing content to the user begins again.

Most browsers use an internal cache of web page resources to improve loading times for subsequent visits to the same page. The cache can store many items, such as large images, so they do not need to be downloaded from the server again. Cached items are usually only stored for as long as the web server stipulates in its HTTP response messages.

EXAMPLE

	private void initComponents() {
		frame = new JFrame();
		paneltop = new JPanel();
		
		try {
			url = new URL("https://www.google.com/");
			
		}
		catch(MalformedURLException mue) {
			JOptionPane.showMessageDialog(null, mue);
		}
		try {
			editor = new JEditorPane(url);
			editor.setEditable(false);
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		scroll = new JScrollPane(editor,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		field = new JTextField();
		field.setBounds(200, 10, 200, 50);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				field.setText(url.toString());
			}
		});
		
		button = new JButton("Go Url");
		button.setBounds(500, 10, 100, 50);
		button.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					editor.setPage(field.getText());
				}
				catch(IOException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
	
	
	}
  
  
