package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");

        //Lager rpcserver på riktig spor
		RPCServer rpcserver = new RPCServer(Common.DISPLAYPORT);

        //Lager display implementasjon
        DisplayImpl display = new DisplayImpl((byte)Common.WRITE_RPCID, rpcserver);

        // Registrerer implementasjonen hos serveren
        rpcserver.register((byte) Common.WRITE_RPCID, display);

        // Starter serveren
        rpcserver.run();
		System.out.println("Display server stopping ...");
		
	}
}
