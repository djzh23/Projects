using De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels.Common;
using De.HsFlensburg.LernkartenApp038.Logic.Ui.Wrapper;
using Limilabs.Client.SMTP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;
using System.Web.UI;
using System.Windows.Input;




namespace De.HsFlensburg.LernkartenApp038.Logic.Ui.ViewModels
{
    public class ShareEmailViewModel: AbstractViewModel
    {

      
        public SetViewModel SelectedItemFormList
        {
            get; set; 
            
        }
        public ICommand SendButton { get; }
        public ICommand FindButton { get; }
        public ListOfSetsViewModel Sets { get; set; }
        public String SearchedNameOfCategory { get; set; }
        public String EmailToSend { get; set; }
        public String sender { get; set; }
        public String password { get; set; }

        private String message; 
        public String Message { get { return this.message; } set { this.message = value; OnPropertyChanged();  } }
       
       
        public ShareEmailViewModel(ListOfSetsViewModel Sets)
        {
            this.Sets = Sets;
            SendButton = new RelayCommand(this.SendToEmail, this.getTrue);
            FindButton = new RelayCommand(this.findCategory, this.getTrue); 
        }

        private void findCategory()
        {
            Console.WriteLine(this.SearchedNameOfCategory); 
     if(this.SearchedNameOfCategory != "")
            {
                bool isFound = false; 
                for( var i = 0; i< this.Sets.Count && !isFound; i++)
                {
                    if(this.Sets[i].Name == this.SearchedNameOfCategory)
                    {
                        isFound = true;
                        this.Sets.Move(i, 0);
                        this.Message = ""; 
                    }
                    else
                    {
                        this.Message = "The searched item is not found!"; 
                    }

                }
            }

        }

        private bool getTrue()
        {
              return true; 
        }

      /*  public static void CreateTestMessage1(string server, int port)
        {
            string to = "zouh.ijd@gmail.com";
            string from = "zouh.ijd@gmail.com";
            string subject = "Using the new SMTP client.";
            string body = @"Using this new feature, you can send an email message from an application very easily.";
            MailMessage message = new MailMessage(from, to, subject, body);
            SmtpClient client = new SmtpClient(server, port);
            // Credentials are necessary if the server requires the client 
            // to authenticate before it will send email on the client's behalf.
            client.Credentials = CredentialCache.DefaultNetworkCredentials;
            client.Send(message);
        }*/

        private void  SendToEmail()
        {


            var fromAddress = new MailAddress(sender, "From Name");
            var toAddress = new MailAddress(EmailToSend, "To Name");
            string fromPassword = password;
            const string subject = "test";
            const string body = "hey";

            var smtp = new SmtpClient
            {
                Host = "smtp.gmail.com",
                Port = 587,
                EnableSsl = true,
                DeliveryMethod = SmtpDeliveryMethod.Network,
                Credentials = new NetworkCredential(fromAddress.Address, fromPassword),
                Timeout = 20000
            };
            using (var message = new MailMessage(fromAddress, toAddress)
            {
                Subject = subject,
                Body = body
            })
            {
                smtp.Send(message);
            }



            Console.WriteLine(this.EmailToSend); 
            //TODO: Ich muss schauen, wie ich dieses Element zu einer Email schicken 
        }

        private void CreateTestMessage1(object com, int v, object port)
        {
            throw new NotImplementedException();
        }


        /*  public bool CheckSMTPConnection(string SMTPServer, string Benutzer, string Passwort)
          {
              bool result = false;
              try
              {
                  MailAddress MailEmpfaenger = new MailAddress("ibrahim.schechsaher1993@gmail.com");
                  MailAddress MailAbsender = new MailAddress("ibrahim.schechsaher@gmail.com");
                  MailMessage message = new MailMessage();
                  SmtpClient client = new SmtpClient(SMTPServer);
                  NetworkCredential credentials = new NetworkCredential(Benutzer, Passwort);
                  client.Credentials = credentials;
                  message.Priority = MailPriority.Normal;
                  message.From = MailAbsender;
                  message.To.Add(MailEmpfaenger);
                  message.Subject = "VERBINDUNGSTEST";
                  message.Body = "VERBINDUNGSTEST";
                  client.Send(message);
                  result = true;
              }
              catch (Exception ex)
              {
                  result = false;
                  throw new Exception(ex.Message);
              }
              return result;
          }*/


    }
}
/*SmtpClient client = new SmtpClient("smtp.gamil.com", 587);
                client.EnableSsl = true;
                client.DeliveryMethod = SmtpDeliveryMethod.Network;
                client.UseDefaultCredentials = false;
                client.Credentials = new NetworkCredential("Ibrahim.schechsaher@gmail.com", "password");
                MailMessage msgobj = new MailMessage();
                msgobj.To.Add("Ibrahim.schechsaher1993@gmail.com");
                msgobj.From = new MailAddress("Ibrahim.schechsaher@gmail.com");
                msgobj.Subject = "csfddsf";
                msgobj.Body ="hi";
                client.Send(msgobj*/




/* System.Net.Mail.MailMessage message = new System.Net.Mail.MailMessage();
 message.To.Add("Ibarhim.schechsaher1993@gmail.com");
 message.Subject = "test in web";
 message.From = new System.Net.Mail.MailAddress("Ibrahim.schechsaher@gmai.com");
 message.Body = "This is the message body";
 System.Net.Mail.SmtpClient smtp = new System.Net.Mail.SmtpClient("smtp.gmail.com");
 smtp.Credentials = new System.Net.NetworkCredential("Ibrahim.schechsaher@gmail.com", "ibo0962277238");
 smtp.Port = 25;
 smtp.Send(message);*/
/*  var mail = new MailMaker()
        {
            Absender = "",
            Empfänger = new List<string>() { "" },
            Kopie = new List<string>() { "hallo@web.de" },
            Blindkopie = new List<string>() { "beispiel@web.de" },
            Betreff = "Hallo",
            Nachricht = "Na wie gehts?",
            Servername = "smtp.gmail.com,
            Port = "25",
            Username = "Ibrahim Schech Saher",
            Passwort = "",
            Anhänge = new List<Attachment> { new Attachment("C:\\ttt.txt") }
        };

        mail.Send();*/
