package com.bl4ckcode.sces.models;

import org.eclipse.emf.ecore.EObject;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Itens Pedido</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.ItensPedido#getQuantidade <em>Quantidade</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.ItensPedido#getId <em>Id</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.ItensPedido#getProduto <em>Produto</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.ItensPedido#getPedido <em>Pedido</em>}</li>
 * </ul>
 *
 * @see com.bl4ckcode.sces.models.EcommerceposPackage#getItensPedido()
 * @model
 * @generated
 */
public interface ItensPedido extends Serializable, EObject {
    /**
     * Returns the value of the '<em><b>Quantidade</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Quantidade</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Quantidade</em>' attribute.
     * @see #setQuantidade(double)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getItensPedido_Quantidade()
     * @model required="true" ordered="false"
     * @generated
     */
    double getQuantidade();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.ItensPedido#getQuantidade <em>Quantidade</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Quantidade</em>' attribute.
     * @see #getQuantidade()
     * @generated
     */
    void setQuantidade(double value);

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(int)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getItensPedido_Id()
     * @model required="true" ordered="false"
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.ItensPedido#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(int value);

    /**
     * Returns the value of the '<em><b>Produto</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Produto</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Produto</em>' containment reference.
     * @see #setProduto(Produto)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getItensPedido_Produto()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    Produto getProduto();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.ItensPedido#getProduto <em>Produto</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Produto</em>' containment reference.
     * @see #getProduto()
     * @generated
     */
    void setProduto(Produto value);

    /**
     * Returns the value of the '<em><b>Pedido</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.bl4ckcode.sces.models.Pedido#getItens_do_pedido <em>Itens do pedido</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pedido</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pedido</em>' container reference.
     * @see #setPedido(Pedido)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getItensPedido_Pedido()
     * @see com.bl4ckcode.sces.models.Pedido#getItens_do_pedido
     * @model opposite="itens_do_pedido" required="true" transient="false" ordered="false"
     * @generated
     */
    Pedido getPedido();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.ItensPedido#getPedido <em>Pedido</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pedido</em>' container reference.
     * @see #getPedido()
     * @generated
     */
    void setPedido(Pedido value);

} // ItensPedido
