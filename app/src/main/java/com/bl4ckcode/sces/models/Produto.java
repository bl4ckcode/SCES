package com.bl4ckcode.sces.models;

import org.eclipse.emf.ecore.EObject;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Produto</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.Produto#getCodigoProduto <em>Codigo Produto</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Produto#getNome <em>Nome</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Produto#getPreco <em>Preco</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Produto#getQuantidadeEstoque <em>Quantidade Estoque</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Produto#getCetgorias <em>Cetgorias</em>}</li>
 * </ul>
 *
 * @see com.bl4ckcode.sces.models.EcommerceposPackage#getProduto()
 * @model
 * @generated
 */
public interface Produto extends Serializable, EObject {
    /**
     * Returns the value of the '<em><b>Codigo Produto</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Codigo Produto</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Codigo Produto</em>' attribute.
     * @see #setCodigoProduto(String)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getProduto_CodigoProduto()
     * @model required="true" ordered="false"
     * @generated
     */
    String getCodigoProduto();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Produto#getCodigoProduto <em>Codigo Produto</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Codigo Produto</em>' attribute.
     * @see #getCodigoProduto()
     * @generated
     */
    void setCodigoProduto(String value);

    /**
     * Returns the value of the '<em><b>Nome</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nome</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nome</em>' attribute.
     * @see #setNome(String)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getProduto_Nome()
     * @model required="true" ordered="false"
     * @generated
     */
    String getNome();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Produto#getNome <em>Nome</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nome</em>' attribute.
     * @see #getNome()
     * @generated
     */
    void setNome(String value);

    /**
     * Returns the value of the '<em><b>Preco</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Preco</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Preco</em>' attribute.
     * @see #setPreco(double)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getProduto_Preco()
     * @model required="true" ordered="false"
     * @generated
     */
    double getPreco();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Produto#getPreco <em>Preco</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Preco</em>' attribute.
     * @see #getPreco()
     * @generated
     */
    void setPreco(double value);

    /**
     * Returns the value of the '<em><b>Quantidade Estoque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Quantidade Estoque</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Quantidade Estoque</em>' attribute.
     * @see #setQuantidadeEstoque(double)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getProduto_QuantidadeEstoque()
     * @model required="true" ordered="false"
     * @generated
     */
    double getQuantidadeEstoque();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Produto#getQuantidadeEstoque <em>Quantidade Estoque</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Quantidade Estoque</em>' attribute.
     * @see #getQuantidadeEstoque()
     * @generated
     */
    void setQuantidadeEstoque(double value);

    /**
     * Returns the value of the '<em><b>Cetgorias</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cetgorias</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cetgorias</em>' containment reference.
     * @see #setCetgorias(Categoria)
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#getProduto_Cetgorias()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
    Categoria getCetgorias();

    /**
     * Sets the value of the '{@link com.bl4ckcode.sces.models.Produto#getCetgorias <em>Cetgorias</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cetgorias</em>' containment reference.
     * @see #getCetgorias()
     * @generated
     */
    void setCetgorias(Categoria value);

} // Produto
