// specify the package
package model;

// system imports
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.*;

// project imports
import userinterface.MainStageContainer;
import userinterface.View;
import userinterface.LoginView;
import userinterface.LoanView;
import userinterface.WindowPosition;

/** The class containing the Loan for the LoanCalculator application */
//==============================================================
public class Loan 
{

    private ArrayList<AccountHolder> myAccountHolders = new ArrayList<AccountHolder>();

    // GUI Components
    private Stage myStage;
    private View loginView;
    private View loanView;
    private Scene currentScene;

    private String loginErrorMessage = "";
    private String transactionErrorMessage = "";

    // constructor for this class
    //----------------------------------------------------------
    public Loan()
    {

        AccountHolder a = new AccountHolder("trao", "RaoT1", "T M Rao");
        myAccountHolders.add(a);
        a = new AccountHolder("smitra", "MitraS1", "S Mitra");
        myAccountHolders.add(a);
        a = new AccountHolder("mcoleman", "Melissa1", "M Coleman");
        myAccountHolders.add(a);
        a = new AccountHolder("rnsmith", "Rebekah1", "R Smith");
        myAccountHolders.add(a);

        myStage = MainStageContainer.getInstance();

        // Set up the initial view
        createAndShowLoginView();
    }

    //----------------------------------------------------------
    public void processLogin(Properties props)
    {
        String un = props.getProperty("ID"); 
        // this is what we did in the View, so it must match
        boolean userFound = false;
        for (int cnt = 0; cnt < myAccountHolders.size(); cnt++)
        {
            String unInList = 
                (myAccountHolders.get(cnt)).username;
            if (unInList.equals(un) == true)
            {
                String pwSent = props.getProperty("Password");
                String uPwd = 
                    (myAccountHolders.get(cnt)).password;
                if (uPwd.equals(pwSent) == true)
                {
                    userFound = true;
                    break;
                }

            }

        }

        if (userFound) // this means login successful
        {
            createAndShowLoanView();
        }
        else
        {
            loginView.updateState("LoginError", "Login failed!");
        }
    }

    //----------------------------------------------------------
    public void processLoan(Properties props)
    {
        String intRateStr = props.getProperty("InterestRate");
        String numYearsStr = props.getProperty("NumYears");
        String amt = props.getProperty("Amount");

        double intRate = Double.parseDouble(intRateStr);
        int numYears = Integer.parseInt(numYearsStr);
        double loanAmount = Double.parseDouble(amt);
        // P = (r * PV) / (1 - (1 + r)^(-n)
        // where P = monthly payment, PV = loan amount, 
        // r = int rate, n = number of periods
        intRate = intRate / (12 * 100);
        int numPeriods = numYears * 12;
        double monthlyPayment = (intRate * loanAmount) / (1 - Math.pow(1 + intRate, -numPeriods));
        double totalPayment = monthlyPayment * numYears * 12;
        
        totalPayment = Math.round(totalPayment * 100.0) / 100.0;
        monthlyPayment = Math.round(monthlyPayment * 100.0) / 100.0;
        
        loanView.updateState("MonthlyPayment", "" + monthlyPayment);
        loanView.updateState("TotalPayment", "" + totalPayment);

    }

    //----------------------------------------------------------
    public void cancelTransaction()
    {
        createAndShowLoginView();
    }

    //----------------------------------------------------------
    private void createAndShowLoanView()
    {

        // create our new view
        loanView = new LoanView (this); 
        currentScene = new Scene(loanView);

        // make the view visible by installing it into the stage
        swapToView(currentScene);

    }

    //------------------------------------------------------------
    private void createAndShowLoginView()
    {
        // create our initial view
        loginView = new LoginView(this);
        // CREATE A SCENE WITH OUR NEW VIEW
        currentScene = new Scene(loginView);

        // make the view visible by installing it into the stage
        swapToView(currentScene);
    }

    //---------------------------------------------------------------
    public void swapToView(Scene newScene)
    {
        if (newScene == null)
        {
            System.out.println
            ("Loan.swapToView(): Missing view for display");
            return;
        }

        // SWAP THE SCENE ON THE STAGE
        myStage.setScene(newScene);
        // RE-SIZE STAGE TO FIT NEW SCENE SIZE
        myStage.sizeToScene();                    
        //Place in center again
        WindowPosition.placeCenter(myStage);

    }
}

