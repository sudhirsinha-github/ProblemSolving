package designpaterns;

import java.util.ArrayList;
import java.util.List;

public class MainApp
  {
      public static void main(String[] args) {

      // Create IBM stock and attach investors

      IBM ibm = new IBM("IBM", 120.00);
      ibm.Attach(new Investor("Sorros"));
      ibm.Attach(new Investor("Berkshire"));
 
      // Fluctuating prices will notify investors

      ibm.set_price(120.10);
      ibm.set_price(120.10);
      ibm.set_price(120.10);
      ibm.set_price(120.10);
      ibm.set_price(120.10);
 
      // Wait for user
    }
  }

  abstract class Stock
  {
    public String get_symbol() {
      return _symbol;
    }

    public void set_symbol(String _symbol) {
      this._symbol = _symbol;
    }

    public double get_price() {
      return _price;
    }

    public void set_price(double _price) {
      if(this._price != _price) {
        this._price = _price;
        notify();
      }
    }

    private String _symbol;
    private double _price;
    private List<IInvestor> _investors = new ArrayList<>();
 
    // Constructor

    public Stock(String symbol, double price)
    {
      this._symbol = symbol;
      this._price = price;
    }
 
    public void Attach(IInvestor investor)
    {
      _investors.add(investor);
    }
 
    public void Detach(IInvestor investor)
    {
      _investors.remove(investor);
    }
 
    public void Notify()
    {
      for (IInvestor investor : _investors)
      {
        investor.Update(this);
      }
      System.out.println("******");
    }

  }
 
  /// <summary>

  /// The 'ConcreteSubject' class

  /// </summary>

  class IBM extends Stock
  {
    // Constructor

    public IBM(String symbol, double price)
    {
   super(symbol, price);
    }
  }
 
  /// <summary>

  /// The 'Observer' interface

  /// </summary>

  interface IInvestor

  {
    void Update(Stock stock);
  }
 
  /// <summary>

  /// The 'ConcreteObserver' class

  /// </summary>

  class Investor implements IInvestor {
    private String _name;
    private Stock _stock;

    // Constructor

    public Investor(String name) {
      this._name = name;
    }

    public void Update(Stock stock) {
      System.out.println(_name + "---->> " + stock.get_symbol() + stock.get_price());
    }

    // Gets or sets the stock
  }