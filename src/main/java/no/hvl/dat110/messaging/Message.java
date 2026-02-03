package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;

	// construction a Message with the data provided
	public Message(byte[] data) {

		if (data != null && data.length <=127) {
			this.data = data;
		} else {
			throw new IllegalArgumentException("Data kan ikke være null eller lenger enn 127 bytes");
		}
		


	}

	public byte[] getData() {
		return this.data; 
	}

}
