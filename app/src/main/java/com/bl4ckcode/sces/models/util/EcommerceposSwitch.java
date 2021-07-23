package com.bl4ckcode.sces.models.util;

import com.bl4ckcode.sces.models.Categoria;
import com.bl4ckcode.sces.models.Cliente;
import com.bl4ckcode.sces.models.EcommerceposPackage;
import com.bl4ckcode.sces.models.ItensPedido;
import com.bl4ckcode.sces.models.Pedido;
import com.bl4ckcode.sces.models.Produto;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.bl4ckcode.sces.models.EcommerceposPackage
 * @generated
 */
public class EcommerceposSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EcommerceposPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcommerceposSwitch() {
		if (modelPackage == null) {
			modelPackage = EcommerceposPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EcommerceposPackage.CLIENTE: {
				Cliente cliente = (Cliente)theEObject;
				T result = caseCliente(cliente);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcommerceposPackage.PEDIDO: {
				Pedido pedido = (Pedido)theEObject;
				T result = casePedido(pedido);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcommerceposPackage.CATEGORIA: {
				Categoria categoria = (Categoria)theEObject;
				T result = caseCategoria(categoria);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcommerceposPackage.PRODUTO: {
				Produto produto = (Produto)theEObject;
				T result = caseProduto(produto);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EcommerceposPackage.ITENS_PEDIDO: {
				ItensPedido itensPedido = (ItensPedido)theEObject;
				T result = caseItensPedido(itensPedido);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cliente</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cliente</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCliente(Cliente object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pedido</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pedido</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePedido(Pedido object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Categoria</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Categoria</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategoria(Categoria object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Produto</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Produto</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProduto(Produto object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Itens Pedido</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Itens Pedido</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItensPedido(ItensPedido object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EcommerceposSwitch
