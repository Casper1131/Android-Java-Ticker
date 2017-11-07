# Android-Java-Ticker
Ticker tick =  new Ticker(<br/>
5000,<br/>
’uichat’,<br/>
0,<br/>
 new TickCallBack(){<br/>
	public void Tick(int count){<br/>
/*request messenger/messages, here you will need to check if Result is empty before updating your list view*/<br/>
}<br/>
},<br/>
new StopCallback(){<br/>
	public void stop(){<br/>
		//timed out<br/>
}<br/>
}<br/>
)
