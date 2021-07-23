package com.bl4ckcode.sces.models.impl;

import com.bl4ckcode.sces.models.Categoria;
import com.bl4ckcode.sces.models.EcommerceposPackage;
import com.bl4ckcode.sces.models.Produto;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Produto</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ProdutoImpl#getCodigoProduto <em>Codigo Produto</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ProdutoImpl#getNome <em>Nome</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ProdutoImpl#getPreco <em>Preco</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ProdutoImpl#getQuantidadeEstoque <em>Quantidade Estoque</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ProdutoImpl#getCetgorias <em>Cetgorias</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProdutoImpl extends MinimalEObjectImpl.Container implements Produto {
    /**
     * The default value of the '{@link #getCodigoProduto() <em>Codigo Produto</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getCodigoProduto()
     */
    protected static final String CODIGO_PRODUTO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCodigoProduto() <em>Codigo Produto</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getCodigoProduto()
     */
    protected String codigoProduto = CODIGO_PRODUTO_EDEFAULT;

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
     * The default value of the '{@link #getPreco() <em>Preco</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getPreco()
     */
    protected static final double PRECO_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getPreco() <em>Preco</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getPreco()
     */
    protected double preco = PRECO_EDEFAULT;

    /**
     * The default value of the '{@link #getQuantidadeEstoque() <em>Quantidade Estoque</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getQuantidadeEstoque()
     */
    protected static final double QUANTIDADE_ESTOQUE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getQuantidadeEstoque() <em>Quantidade Estoque</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getQuantidadeEstoque()
     */
    protected double quantidadeEstoque = QUANTIDADE_ESTOQUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getCetgorias() <em>Cetgorias</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getCetgorias()
     */
    protected Categoria cetgorias;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected ProdutoImpl() {
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
        return EcommerceposPackage.Literals.PRODUTO;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setCodigoProduto(String newCodigoProduto) {
        String oldCodigoProduto = codigoProduto;
        codigoProduto = newCodigoProduto;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PRODUTO__CODIGO_PRODUTO, oldCodigoProduto, codigoProduto));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PRODUTO__NOME, oldNome, nome));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public double getPreco() {
        return preco;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setPreco(double newPreco) {
        double oldPreco = preco;
        preco = newPreco;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PRODUTO__PRECO, oldPreco, preco));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setQuantidadeEstoque(double newQuantidadeEstoque) {
        double oldQuantidadeEstoque = quantidadeEstoque;
        quantidadeEstoque = newQuantidadeEstoque;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PRODUTO__QUANTIDADE_ESTOQUE, oldQuantidadeEstoque, quantidadeEstoque));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Categoria getCetgorias() {
        return cetgorias;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetCetgorias(Categoria newCetgorias, NotificationChain msgs) {
        Categoria oldCetgorias = cetgorias;
        cetgorias = newCetgorias;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PRODUTO__CETGORIAS, oldCetgorias, newCetgorias);
            if (msgs == null) msgs = notification;
            else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setCetgorias(Categoria newCetgorias) {
        if (newCetgorias != cetgorias) {
            NotificationChain msgs = null;
            if (cetgorias != null)
                msgs = ((InternalEObject) cetgorias).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcommerceposPackage.PRODUTO__CETGORIAS, null, msgs);
            if (newCetgorias != null)
                msgs = ((InternalEObject) newCetgorias).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcommerceposPackage.PRODUTO__CETGORIAS, null, msgs);
            msgs = basicSetCetgorias(newCetgorias, msgs);
            if (msgs != null) msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PRODUTO__CETGORIAS, newCetgorias, newCetgorias));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EcommerceposPackage.PRODUTO__CETGORIAS:
                return basicSetCetgorias(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
            case EcommerceposPackage.PRODUTO__CODIGO_PRODUTO:
                return getCodigoProduto();
            case EcommerceposPackage.PRODUTO__NOME:
                return getNome();
            case EcommerceposPackage.PRODUTO__PRECO:
                return getPreco();
            case EcommerceposPackage.PRODUTO__QUANTIDADE_ESTOQUE:
                return getQuantidadeEstoque();
            case EcommerceposPackage.PRODUTO__CETGORIAS:
                return getCetgorias();
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
            case EcommerceposPackage.PRODUTO__CODIGO_PRODUTO:
                setCodigoProduto((String) newValue);
                return;
            case EcommerceposPackage.PRODUTO__NOME:
                setNome((String) newValue);
                return;
            case EcommerceposPackage.PRODUTO__PRECO:
                setPreco((Double) newValue);
                return;
            case EcommerceposPackage.PRODUTO__QUANTIDADE_ESTOQUE:
                setQuantidadeEstoque((Double) newValue);
                return;
            case EcommerceposPackage.PRODUTO__CETGORIAS:
                setCetgorias((Categoria) newValue);
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
            case EcommerceposPackage.PRODUTO__CODIGO_PRODUTO:
                setCodigoProduto(CODIGO_PRODUTO_EDEFAULT);
                return;
            case EcommerceposPackage.PRODUTO__NOME:
                setNome(NOME_EDEFAULT);
                return;
            case EcommerceposPackage.PRODUTO__PRECO:
                setPreco(PRECO_EDEFAULT);
                return;
            case EcommerceposPackage.PRODUTO__QUANTIDADE_ESTOQUE:
                setQuantidadeEstoque(QUANTIDADE_ESTOQUE_EDEFAULT);
                return;
            case EcommerceposPackage.PRODUTO__CETGORIAS:
                setCetgorias((Categoria) null);
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
            case EcommerceposPackage.PRODUTO__CODIGO_PRODUTO:
                return CODIGO_PRODUTO_EDEFAULT == null ? codigoProduto != null : !CODIGO_PRODUTO_EDEFAULT.equals(codigoProduto);
            case EcommerceposPackage.PRODUTO__NOME:
                return NOME_EDEFAULT == null ? nome != null : !NOME_EDEFAULT.equals(nome);
            case EcommerceposPackage.PRODUTO__PRECO:
                return preco != PRECO_EDEFAULT;
            case EcommerceposPackage.PRODUTO__QUANTIDADE_ESTOQUE:
                return quantidadeEstoque != QUANTIDADE_ESTOQUE_EDEFAULT;
            case EcommerceposPackage.PRODUTO__CETGORIAS:
                return cetgorias != null;
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
        result.append(" (codigoProduto: ");
        result.append(codigoProduto);
        result.append(", nome: ");
        result.append(nome);
        result.append(", preco: ");
        result.append(preco);
        result.append(", quantidadeEstoque: ");
        result.append(quantidadeEstoque);
        result.append(')');
        return result.toString();
    }
} //ProdutoImpl
