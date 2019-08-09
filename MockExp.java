package com.curso.javaaccenturecurso.service;

import com.curso.javaaccenturecurso.entidade.Produto;
import com.curso.javaaccenturecurso.repository.ProdutoRepository;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceTest
{
    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

//    @Deployment
//    public static JavaArchive createDeployment()
//    {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(ProdutoService.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }

    @Test
    public void findAll()
    {
        Iterable<Produto> prodInter = new Iterable<Produto>()
        {
            @Override
            public Iterator<Produto> iterator()
            {
                List<Produto> prodList = Arrays.asList(new Produto());
                return prodList.iterator();
            }
        };

        //Force a return value
        Mockito.when(this.repository.findAll()).thenReturn(prodInter);

        Mockito.verify(this.repository, Mockito.atLeast(  1)).findAll();
    }

    @Test
    public void findAllNull()
    {
        Assert.assertNull(this.service.findAllXablau());
    }

    @Test
    public void findAllXablau()
    {
        Iterable<Produto> listProduto = new Iterable<Produto>()
        {
            @Override
            public Iterator<Produto> iterator()
            {
                List<Produto> prods = Arrays.asList(new Produto(), new Produto(), new Produto());
                return prods.iterator();
            }
        };

        //Force a return value
        Mockito.when(this.repository.findAll()).thenReturn(null);

        Iterable<Produto> prods = this.service.findAllXablau();

        Assert.assertNotNull(prods);
        Assert.assertEquals(3, Iterables.size(prods));


        Mockito.verify(this.repository, Mockito.atLeast(  1)).findAll();
    }

}
