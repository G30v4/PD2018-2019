package com.distribuida.ejb.servicios;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.ejb.Local;

@Local
public interface ServicioOperaciones extends Remote {

	public int sumar( int n1, int n2 ) throws RemoteException;
}

