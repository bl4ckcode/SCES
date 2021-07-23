package com.bl4ckcode.sces.models;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pedido</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.Pedido#getCodigoPedido <em>Codigo Pedido</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Pedido#getDataPedido <em>Data Pedido</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Pedido#getClientes <em>Clientes</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Pedido#getItens_do_pedido <em>Itens do pedido</em>}</li>
 * </ul>
 *
 * @see com.bl4ckcode.sces.models.EcommerceposPackage#getPedido()
 * @model
 * @generated
 */
public interface Pedido extends Serializable, EObject {
    /**
     * Returns the value of the '<em><b>Codigo Pedido</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Codigo Pedido</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Codigo Pedido</em>' attribute.
     * @see #setCodigoPedido(String)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getPedido_CodigoPedido()
     * @model required="true" ordered="false"
     * @generated
     */
    String getCodigoPedido();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Pedido#getCodigoPedido <em>Codigo Pedido</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Codigo Pedido</em>' attribute.
     * @see #getCodigoPedido()
     * @generated
     */
    void setCodigoPedido(String value);

    /**
     * Returns the value of the '<em><b>Data Pedido</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Pedido</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Pedido</em>' attribute.
     * @see #setDataPedido(String)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getPedido_DataPedido()
     * @model required="true" ordered="false"
     * @generated
     */
    String getDataPedido();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Pedido#getDataPedido <em>Data Pedido</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Pedido</em>' attribute.
     * @see #getDataPedido()
     * @generated
     */
    void setDataPedido(String value);

    /**
     * Returns the value of the '<em><b>Clientes</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Clientes</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Clientes</em>' containment reference.
     * @see #setClientes(Cliente)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getPedido_Clientes()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    Cliente getClientes();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Pedido#getClientes <em>Clientes</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Clientes</em>' containment reference.
     * @see #getClientes()
     * @generated
     */
    void setClientes(Cliente value);

    /**
     * Returns the value of the '<em><b>Itens do pedido</b></em>' containment reference list.
     * The list contents are of type {@link com.bl4ckcode.sces.models.ItensPedido}.
     * It is bidirectional and its opposite is '{@link com.bl4ckcode.sces.models.ItensPedido#getPedido <em>Pedido</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Itens do pedido</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Itens do pedido</em>' containment reference list.
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getPedido_Itens_do_pedido()
     * @see com.bl4ckcode.sces.models.ItensPedido#getPedido
     * @model opposite="pedido" containment="true" ordered="false"
     * @generated
     */
    EList<ItensPedido> getItens_do_pedido();

} // Pedido
