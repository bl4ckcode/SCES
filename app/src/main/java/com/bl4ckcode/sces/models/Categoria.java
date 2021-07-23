package com.bl4ckcode.sces.models;

import org.eclipse.emf.ecore.EObject;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Categoria</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.Categoria#getCodigo <em>Codigo</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.Categoria#getNome <em>Nome</em>}</li>
 * </ul>
 *
 * @see com.bl4ckcode.sces.models.EcommerceposPackage#getCategoria()
 * @model
 * @generated
 */
public interface Categoria extends Serializable, EObject {
	/**
	 * Returns the value of the '<em><b>Codigo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Codigo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codigo</em>' attribute.
	 * @see #setCodigo(String)
	 * @see com.bl4ckcode.sces.models.EcommerceposPackage#getCategoria_Codigo()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getCodigo();

	/**
	 * Sets the value of the '{@link com.bl4ckcode.sces.models.Categoria#getCodigo <em>Codigo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codigo</em>' attribute.
	 * @see #getCodigo()
	 * @generated
	 */
	void setCodigo(String value);

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
	 * @see com.bl4ckcode.sces.models.EcommerceposPackage#getCategoria_Nome()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getNome();

	/**
	 * Sets the value of the '{@link com.bl4ckcode.sces.models.Categoria#getNome <em>Nome</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nome</em>' attribute.
	 * @see #getNome()
	 * @generated
	 */
	void setNome(String value);

} // Categoria
