package com.bl4ckcode.sces.models.util;

import com.bl4ckcode.sces.models.Categoria;
import com.bl4ckcode.sces.models.Cliente;
import com.bl4ckcode.sces.models.EcommerceposPackage;
import com.bl4ckcode.sces.models.ItensPedido;
import com.bl4ckcode.sces.models.Pedido;
import com.bl4ckcode.sces.models.Produto;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.bl4ckcode.sces.models.EcommerceposPackage
 * @generated
 */
public class EcommerceposAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcommerceposPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcommerceposAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EcommerceposPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcommerceposSwitch<Adapter> modelSwitch =
		new EcommerceposSwitch<Adapter>() {
			@Override
			public Adapter caseCliente(Cliente object) {
				return createClienteAdapter();
			}
			@Override
			public Adapter casePedido(Pedido object) {
				return createPedidoAdapter();
			}
			@Override
			public Adapter caseCategoria(Categoria object) {
				return createCategoriaAdapter();
			}
			@Override
			public Adapter caseProduto(Produto object) {
				return createProdutoAdapter();
			}
			@Override
			public Adapter caseItensPedido(ItensPedido object) {
				return createItensPedidoAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.bl4ckcode.sces.models.Cliente <em>Cliente</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.bl4ckcode.sces.models.Cliente
	 * @generated
	 */
	public Adapter createClienteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.bl4ckcode.sces.models.Pedido <em>Pedido</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.bl4ckcode.sces.models.Pedido
	 * @generated
	 */
	public Adapter createPedidoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.bl4ckcode.sces.models.Categoria <em>Categoria</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.bl4ckcode.sces.models.Categoria
	 * @generated
	 */
	public Adapter createCategoriaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.bl4ckcode.sces.models.Produto <em>Produto</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.bl4ckcode.sces.models.Produto
	 * @generated
	 */
	public Adapter createProdutoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.bl4ckcode.sces.models.ItensPedido <em>Itens Pedido</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.bl4ckcode.sces.models.ItensPedido
	 * @generated
	 */
	public Adapter createItensPedidoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EcommerceposAdapterFactory
