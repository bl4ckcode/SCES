package com.bl4ckcode.sces.models.impl;

import com.bl4ckcode.sces.models.Categoria;
import com.bl4ckcode.sces.models.EcommerceposPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Categoria</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.impl.CategoriaImpl#getCodigo <em>Codigo</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.CategoriaImpl#getNome <em>Nome</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CategoriaImpl extends MinimalEObjectImpl.Container implements Categoria {
    /**
     * The default value of the '{@link #getCodigo() <em>Codigo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getCodigo()
     */
    protected static final String CODIGO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCodigo() <em>Codigo</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getCodigo()
     */
    protected String codigo = CODIGO_EDEFAULT;

    /**
     * The default value of the '{@link #getNome() <em>Nome</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getNome()
     */
    protected static final String NOME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNome() <em>Nome</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getNome()
     */
    protected String nome = NOME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected CategoriaImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcommerceposPackage.Literals.CATEGORIA;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setCodigo(String newCodigo) {
        String oldCodigo = codigo;
        codigo = newCodigo;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CATEGORIA__CODIGO, oldCodigo, codigo));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getNome() {
        return nome;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setNome(String newNome) {
        String oldNome = nome;
        nome = newNome;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CATEGORIA__NOME, oldNome, nome));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EcommerceposPackage.CATEGORIA__CODIGO:
                return getCodigo();
            case EcommerceposPackage.CATEGORIA__NOME:
                return getNome();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EcommerceposPackage.CATEGORIA__CODIGO:
                setCodigo((String) newValue);
                return;
            case EcommerceposPackage.CATEGORIA__NOME:
                setNome((String) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case EcommerceposPackage.CATEGORIA__CODIGO:
                setCodigo(CODIGO_EDEFAULT);
                return;
            case EcommerceposPackage.CATEGORIA__NOME:
                setNome(NOME_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EcommerceposPackage.CATEGORIA__CODIGO:
                return CODIGO_EDEFAULT == null ? codigo != null : !CODIGO_EDEFAULT.equals(codigo);
            case EcommerceposPackage.CATEGORIA__NOME:
                return NOME_EDEFAULT == null ? nome != null : !NOME_EDEFAULT.equals(nome);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (codigo: ");
        result.append(codigo);
        result.append(", nome: ");
        result.append(nome);
        result.append(')');
        return result.toString();
    }

} //CategoriaImpl
